package com.centili.test.rest.environment;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import com.centili.dao.DocumentDAO;
import com.centili.model.Document;
import com.centili.test.rest.DocumentDAOTest;

public abstract class AbstractDAOTest {
	
	@Deployment
	public static JavaArchive setUpDeployment() throws Exception {

		JavaArchive application = ShrinkWrap
				.create(JavaArchive.class)
				.addPackages(true,
						Document.class.getPackage(),
						DocumentDAO.class.getPackage())
				.addClasses(AbstractDAOTest.class, DocumentDAOTest.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

		return application;
	}

}