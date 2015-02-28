/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.jetty;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.centerkey.utils.BareBonesBrowserLaunch;

@SpringBootApplication
public class SampleJettySslApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(SampleJettySslApplication.class, args);
		System.out.println("Done with run.  ctx="+ctx);
		launchBrowser();
	}

	
	private static void launchBrowser() throws IOException, URISyntaxException {
		String urlStr = "https://localhost:8443";
		if(Desktop.isDesktopSupported())
		{
		  Desktop.getDesktop().browse(new URI(urlStr));
		  System.out.println("Just tried to launch browser to "+urlStr);
		} else { 
			System.out.println("Desktop not supported.  boo!");
			BareBonesBrowserLaunch.openURL(urlStr);
			System.out.println("Just tried: BareBonesBrowserLaunch.openURL");
		}
	}
	
}
