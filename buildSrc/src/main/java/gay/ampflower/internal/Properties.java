package gay.ampflower.internal;

import org.gradle.api.Project;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public final class Properties {
	private static final String pluginStr = "gay.ampflower.";

	public static boolean bool(Project project, String property) {
		final var p = project.property(property);
		if (p instanceof Boolean bool) {
			return bool;
		}
		if (p instanceof String str) {
			return Boolean.parseBoolean(str);
		}
		return false;
	}

	public static @Nullable String str(Project project, String property) {
		final var p = project.property(property);
		if (p == null) {
			return null;
		}
		return p.toString();
	}

	public static boolean pluginBool(Project project, String property) {
		return bool(project, pluginStr + property);
	}


	public static @Nullable String pluginStr(Project project, String property) {
		return str(project, pluginStr + property);
	}
}
