package gay.ampflower.internal;

import org.gradle.api.Project;
import org.gradle.api.artifacts.VersionCatalog;
import org.gradle.api.artifacts.VersionConstraint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public class Util {
	private static final Logger logger = LoggerFactory.getLogger(Util.class);

	public static String urlEncode(String str) {
		return URLEncoder.encode(str, StandardCharsets.UTF_8);
	}

	public static String mkChangelog(String git, String forge) {
		if (!isBlank(Env.Changelog)) {
			logger.debug("Changelog found, returning {}", Env.Changelog);
			return Env.Changelog;
		}

		if (git == null) {
			logger.warn("Git repository not defined. Returning null.");
			return null;
		}

        final var host = VcsHost.find(git, forge);
        if (host == null) {
            logger.warn("Forge not found. Returning bare link to {}", git);
        } else if (startsWith(Env.Reference, "refs/tags/")) {

			logger.warn("Changelog not found but tag reference was, returning link to {}{}{}",
				git, host.release, urlEncode(Env.getTag()));

			return "You may view the changelog at " + git + host.release + urlEncode(Env.getTag());
		}

		logger.warn("Changelog and reference not found, returning link to {}", git);
		return "No changelog is available. Perhaps poke at " + git + " for a changelog?";
	}

	public static String mkVersion(final String baseVersion) {
		if (Env.Publish) {
			return baseVersion;
		}

		if (Env.Actions) {
			return baseVersion + "-build." + Env.getRunNumber() + "-commit." + Env.getCommit(7) + "-branch." + getBranchForVersion();
		}

		return baseVersion + "-build.local";
	}

	private static String getBranchForVersion() {
		final var ref = Env.getBranch();
		if (ref == null) {
			return "unknown";
		}
		return ref.replace('/', '.');
	}

	public static List<String> getCompatibleVersions(VersionCatalog catalog, Project module) {
		Optional<VersionConstraint> version;
		switch (module.getName().toLowerCase()) {
			case "neoforge":
				version = catalog.findVersion("minecraft-neoforge-compatible");
				logger.info("Testing Neoforge: {}", version);
				if (version.isPresent()) break;
			case "forge":
				version = catalog.findVersion("minecraft-forge-compatible");
				logger.info("Testing Forge: {}", version);
				if (version.isPresent()) break;
			case "quilt":
				version = catalog.findVersion("minecraft-quilt-compatible");
				logger.info("Testing Quilt: {}", version);
				if (version.isPresent()) break;
			case "fabric":
				version = catalog.findVersion("minecraft-fabric-compatible");
				logger.info("Testing Fabric: {}", version);
				if (version.isPresent()) break;
			default:
				version = catalog.findVersion("minecraft-compatible");
				logger.info("Testing default: {}", version);
		}

		if (version.isEmpty()) {
			final var minecraft = catalog.findLibrary("minecraft").map(provider -> provider.get().getVersion());

			if (minecraft.isPresent()) {
				logger.warn("No marked compatible versions available for {}; compatible version will be marked as {}.",
					module, minecraft.get());
				return List.of(minecraft.get());
			}

			logger.warn("No marked compatible versions available for {}; compatible versions will not be marked.", module);
			return List.of();
		}

		return List.of(version.get().getRequiredVersion().split(","));
	}

	public static String getVersionType(String version) {
		if (!Util.isBlank(Env.ReleaseOverride)) {
			return Env.ReleaseOverride;
		}

		if (version.contains("alpha")) {
			return "alpha";
		}

		if (!Env.Release || version.indexOf('-') >= 0) {
			return "beta";
		}

		return "release";
	}

	public static boolean isBlank(@Nullable String str) {
		if (str == null) {
			return true;
		}
		return str.isBlank();
	}

	public static boolean startsWith(@Nullable String str, @NotNull String prefix) {
		if (str == null) {
			return false;
		}
		return str.startsWith(prefix);
	}
}
