package gay.ampflower;

import org.gradle.api.Project;
import org.gradle.api.provider.ListProperty;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;

/**
 * @author Ampflower
 * @since 0.0.0
 **/
public class ModExtension {
	private final Property<String> id, version, name, description, icon;
	private final Property<Environment> environment;
	private final ListProperty<String> authors, licenses;
	private final MapProperty<String, String> contact;
	//private final Map<String, List<String>> entrypoints;

	public ModExtension(Project project) {
		final var rootProject = project.getRootProject();
		final var objectFactory = project.getObjects();

		this.id = objectFactory.property(String.class).convention(rootProject.getName());
		this.version = objectFactory.property(String.class).convention((String) project.getVersion());
		this.name = objectFactory.property(String.class).convention(rootProject.getDisplayName());
		this.description = objectFactory.property(String.class).convention(rootProject.getDescription());

		this.authors = objectFactory.listProperty(String.class);
		this.contact = objectFactory.mapProperty(String.class, String.class);
		this.licenses = objectFactory.listProperty(String.class);

		this.icon = objectFactory.property(String.class);
		this.environment = objectFactory.property(Environment.class);
	}

	public Property<String> getId() {
		return this.id;
	}

	public Property<String> getVersion() {
		return this.version;
	}

	public Property<String> getName() {
		return this.name;
	}

	public Property<String> getDescription() {
		return this.description;
	}

	public ListProperty<String> getAuthors() {
		return this.authors;
	}

	public MapProperty<String, String> getContact() {
		return this.contact;
	}

	public ListProperty<String> getLicenses() {
		return this.licenses;
	}

	public Property<String> getIcon() {
		return this.icon;
	}

	public Property<Environment> getEnvironment() {
		return this.environment;
	}

	//public void depend(String dependency, Action<>)
}
