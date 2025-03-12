package gay.pridecraft.joy.client;

import com.mojang.logging.LogUtils;
import gay.pridecraft.joy.JoyUtil;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public final class SplashUtil {
    private static final Logger logger = LogUtils.getLogger();
    private static final Random random = new Random();
    private static final Identifier joySplashes = JoyUtil.id("texts/splashes.txt");
    private static final Map<Birthday, List<String>> birthdays = new HashMap<>();
    private static final List<String> contributors = makeContributors();

    private static final byte
            JAN = 1,
            FEB = 2,
            MAR = 3,
            APR = 4,
            MAY = 5,
            JUN = 6,
            JUL = 7,
            AUG = 8,
            SEP = 9,
            OCT = 10,
            NOV = 11,
            DEC = 12;

    public static void init() {
        putBirthday(MAR, 18, "TheClashFruit");
        putBirthday(SEP, 14, "Blurry");
        putBirthday(NOV, 8, "Fery");
    }

    private static List<String> makeContributors() {
        final var metadata = JoyUtil.joyContainer.getMetadata();

        final var authors = metadata.getAuthors()
                .stream()
                .map(person -> "Joy, made by " + person.getName() + "!");

        final var contributors = metadata.getContributors()
                .stream()
                .map(person -> "Joy, aided by " + person.getName() + "!");

        return Stream.concat(authors, contributors).toList();
    }

    public static List<String> prepare(ResourceManager manager) {
        try (final var reader = manager.openAsReader(joySplashes)) {
            return Stream.concat(
                    reader.lines().map(String::trim).filter(str -> !str.isEmpty()),
                    contributors.stream()
            ).toList();
        } catch (IOException ioe) {
            logger.warn("Could not read Joy splashes", ioe);
        }

        return contributors;
    }

    private static void putBirthday(int month, int day, String... name) {
        birthdays.put(new Birthday(month, day), List.of(name));
    }

    public static List<String> getBirthdays() {
        return birthdays.get(Birthday.now());
    }

    public static String getBirthday(double chance) {
        if (random.nextDouble() < chance) {
            return null;
        }

        final var list = getBirthdays();
        if (list == null || list.isEmpty()) {
            return null;
        }

        return "Happy birthday, " + getRandom(list) + "!";
    }

    private static <T> T getRandom(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    private record Birthday(byte month, byte day) {
        private Birthday(int month, int day) {
            this((byte) month, (byte) day);
        }

        public static Birthday now() {
            final var now = LocalDate.now();
            return new Birthday(now.getMonthValue(), now.getDayOfMonth());
        }

        @Override
        public int hashCode() {
            return (month << 8) | day;
        }
    }
}
