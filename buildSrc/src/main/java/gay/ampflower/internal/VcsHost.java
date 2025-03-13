package gay.ampflower.internal;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public enum VcsHost {
	GitHub("github.com", "/issues", "/releases/tag/"),
	GitLab("gitlab.com", "/-/issues", "/-/releases/"),
	Codeberg("codeberg.org", "/issues", "/releases/tag/");

	public final String host, issues, release;

	VcsHost(String host, String issues, String release) {
		this.host = host;
		this.issues = issues;
		this.release = release;
	}

	public static VcsHost find(String url) {
		// "https://".length = 8
		final int lastSlash = url.indexOf('/', 8);
		for (final var host : values()) {
			final var str = host.host;
			final var len = str.length();
			if (len > lastSlash) continue;
			if (url.regionMatches(lastSlash - len, str, 0, len)) {
				return host;
			}
		}
		return null;
	}
}
