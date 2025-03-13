package gay.ampflower.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public final class Env {
	public static final boolean Publish = "release".equals(env("GITHUB_EVENT_NAME"));
	public static final boolean Release = bool("BUILD_RELEASE");
	public static final boolean Actions = bool("GITHUB_ACTIONS");

	public static final @Nullable String Commit = env("GITHUB_SHA");
	public static final @Nullable String RunNumber = env("GITHUB_RUN_NUMBER");
	public static final @Nullable String Reference = env("GITHUB_REF");
	public static final @Nullable String Changelog = env("CHANGELOG");
	public static final @Nullable String ReleaseOverride = env("RELEASE_OVERRIDE");

	private Env() {
	}

	public static boolean isReferenceTag() {
		return Util.startsWith(Reference, "refs/tags/");
	}

	public static boolean isReferenceBranch() {
		return Util.startsWith(Reference, "refs/heads/");
	}

	public static @Nullable String getTag() {
		if (isReferenceTag()) {
			return Reference.substring(10);
		}
		return null;
	}

	public static @Nullable String getBranch() {
		if (isReferenceBranch()) {
			return Reference.substring(11);
		}
		return null;
	}

	public static String getCommit(int limit) {
		if (Commit == null) {
			return "unknown";
		}
		if (limit > 0) {
			return Commit.substring(0, Math.min(Commit.length(), limit));
		}
		return Commit;
	}

	public static String getRunNumber() {
		if (RunNumber == null) {
			return "unknown";
		}
		return RunNumber;
	}

	public static String getReference() {
		if (Reference == null) {
			return "unknown";
		}
		return Reference;
	}

	public static @Nullable String env(@NotNull String env) {
		return System.getenv(env);
	}

	public static boolean bool(@NotNull String env) {
		return Boolean.parseBoolean(env(env));
	}
}
