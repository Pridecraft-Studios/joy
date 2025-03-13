package gay.ampflower;

import java.util.List;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public record Meta(
	String projectVersion,
	String globalVersion,
	String releaseType,
	String changelog,
	List<String> minecraftCompatible
) {
}
