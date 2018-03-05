package com.centili.test.rest.environment;

import java.net.URL;

import javax.ws.rs.client.WebTarget;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.centili.Activator;

public abstract class AbstractControllerTest {
	
	@Deployment(testable = false)
	public static WebArchive setUpDeployment() throws Exception {

		WebArchive application = ShrinkWrap
				.create(WebArchive.class)
				.addPackages(true, Activator.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");

		return application;
	}
		
	@ArquillianResource
	private URL deployUrl;
	
	protected WebTarget getDeployWebTarget() {
		return ResteasyClientBuilder.newClient().target(deployUrl.toExternalForm());
	}
	
}