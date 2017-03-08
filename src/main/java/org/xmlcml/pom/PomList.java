package org.xmlcml.pom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/** list of Poms.
 * 
 * @author pm286
 *
 */
public class PomList {
	private static final Logger LOG = Logger.getLogger(PomList.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}

	private List<String> projectNames;
	private File directory;
	private List<Pom> pomList;

	public PomList() {
	}
	
	public PomList(File directory, List<String> projectNames) {
		setProjectNames(projectNames);
		setDirectory(directory);
		getOrCreatePoms();
	}

	private void setDirectory(File directory) {
		this.directory = directory;
	}

	public void setProjectNames(List<String> projectNames) {
		this.projectNames = projectNames;
	}
	
	public List<Pom> getOrCreatePoms() {
		pomList = new ArrayList<Pom>();
		if (directory != null && directory.isDirectory() && directory.exists() && projectNames != null) {
			for (String projectName : projectNames) {
				File directory1 = new File(directory, projectName);
				File pomFile = new File(directory1, "pom.xml");
				if (pomFile.exists() && !pomFile.isDirectory()) {
					Pom pom = new Pom(pomFile);
					pomList.add(pom);
				}
			}
		}
		return pomList;
	}
	
	public Pom getPom(MvnProject project) {
		Pom pom = null;
		if (project != null) {
			for (Pom pom1 : pomList) {
				if (project.equals(pom1.getMvnProject())) {
					pom = pom1;
					break;
				}
			}
		}
		return pom;
	}
	

}
