package gay.ampflower;

import gay.ampflower.internal.Env;
import gay.ampflower.internal.Properties;
import gay.ampflower.internal.Util;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.VersionCatalogsExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public class BuildPlugin implements Plugin<Project> {
	private static final Logger logger = LoggerFactory.getLogger(BuildPlugin.class);

	@Override
	public void apply(final Project target) {
		final var extensions = target.getExtensions();

		if (extensions.findByType(Meta.class) != null) {
			logger.warn("Meta already registered in {}, bailing", target);
			return;
		}

		final var libs = target.getRootProject().getExtensions().getByType(VersionCatalogsExtension.class).named("libs");

		final var version = Properties.str(target, "version");
		final var minecraftVersion = libs.findLibrary("minecraft").get().get().getVersionConstraint().getRequiredVersion();

		extensions.add("ci", new CiStatus(
			Env.Publish,
			Env.Release,
			Env.Actions
		));

		extensions.add("meta", new Meta(
			version,
			Util.mkVersion(version + "+mc." + minecraftVersion),
			Util.getVersionType(version),
			Util.mkChangelog(Properties.str(target, "github"), Properties.str(target, "forge")),
			Util.getCompatibleVersions(libs, target)
		));

		extensions.add("mod", ModExtension.class);

		logger.info("Got {}", extensions.findByName("meta"));
	}
}
