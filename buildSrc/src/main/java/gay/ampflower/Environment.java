package gay.ampflower;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public enum Environment {
	ANY("*", "*", "BOTH"),
	CLIENT("client", "client", "CLIENT"),
	SERVER("server", "dedicated_server", "SERVER"),
	;

	public final String fabric, quilt, forge;

	Environment(String fabric, String quilt, String forge) {
		this.fabric = fabric;
		this.quilt = quilt;
		this.forge = forge;
	}
}
