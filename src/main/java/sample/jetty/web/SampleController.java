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

package sample.jetty.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mattpayne.demo.dao.ResultSetExtractorListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.jetty.service.HelloWorldService;

@Controller
public class SampleController {

	@Autowired
	private HelloWorldService helloWorldService;

	@Autowired
	private DataSource dataSource;
	
	//TODO: Add a user and be vulnerable to Bobby Tables: http://xkcd.com/327/

	@RequestMapping("/idLookup")
	@ResponseBody
	public String getUserName(
			@RequestParam(value = "id", defaultValue = "2") String id) {
		String retval;

		try {
			NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(
					dataSource);
			String sql = "select * from users where id = " + id;
			ResultSetExtractorListMap rse = new ResultSetExtractorListMap();
			List<Map<String, Object>> lstMap = jdbc.query(sql, rse);
			String username = (String) lstMap.get(0).get("USERNAME");
			retval = String.format("Username '%s' has id=%s", username, id);
		} catch (Exception bland) {
			bland.printStackTrace();

			Writer result = new StringWriter();
			PrintWriter printWriter = new PrintWriter(result);
			bland.printStackTrace(printWriter);
			retval = result.toString();
		}
		return retval;
	}

	@RequestMapping("/h2")
	@ResponseBody
	public String helloWorld(
			@RequestParam(value = "name", defaultValue = "World") String newName) {
		String retval = this.helloWorldService.getHelloMessage() + " newName="
				+ newName;

		System.out.println("dataSource=" + dataSource);
		NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(
				dataSource);
		String sql = "select * from users";
		ResultSetExtractorListMap rse = new ResultSetExtractorListMap();
		List<Map<String, Object>> lstMap = jdbc.query(sql, rse);
		for (Map<String, Object> map : lstMap) {
			System.out.println("map=" + map);
		}
		lstMap = null;
		try {
			int size = lstMap.size();
		} catch (Exception bland) {
			bland.printStackTrace();

			Writer result = new StringWriter();
			PrintWriter printWriter = new PrintWriter(result);
			bland.printStackTrace(printWriter);
			retval = result.toString();
		}
		return retval;
	}

}
