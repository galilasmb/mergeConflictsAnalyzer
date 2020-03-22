package mergeConflictsAnalyzer.ufpe;

public class Project {
	private String linkGit;
	private String name;
	private String path;
	
	public Project(String linkGit, String name, String path) {
		this.linkGit = linkGit;
		this.name = name;
		this.path = path;
	}

	public String getLinkGit() {
		return linkGit;
	}

	public void setLinkGit(String linkGit) {
		this.linkGit = linkGit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
