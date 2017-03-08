package org.xmlcml.pom;

import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import org.xmlcml.Fixtures;

public class PomListTest {
	private static final Logger LOG = Logger.getLogger(PomListTest.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}

	@Test
	public void testAllPomList() {
		List<String> projects = Arrays.asList(new String[] {
				"cm-pom", "euclid", "svg", "html", "imageanalysis", "diagramanalyzer",
				"pdf2svg", "svg2xml", "cproject", "norma", "ami"});
		PomList pomList = new PomList(Fixtures.POM_DIR, projects);
		List<Pom> poms = pomList.getOrCreatePoms();
		Assert.assertEquals(11,  poms.size());
		for (Pom pom : poms) {
			LOG.debug(pom.toString());
			for (MvnProject dependency : pom.getOrCreateDependencies()) {
				LOG.debug("...."+dependency);
			}
		}
	
	}
}
