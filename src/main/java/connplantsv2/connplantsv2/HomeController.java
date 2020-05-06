/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package connplantsv2.connplantsv2;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	Login login1 = new Login();
	
	@GetMapping
    public String index() {
      return "redirect:/login";
    }
	
	@PostMapping("/welcome")
    public String index1() {
      return "welcome";
    }
	
	@GetMapping("/login")
	  public String loginForm(Model model) {
	    model.addAttribute("login", new Login());
	    return "login";
	  }
	
	  @PostMapping("/login")
	  public String loginSubmit(@ModelAttribute Login login) {
		  login1 = login;
		  String SOURL = "http://"+login.getIp()+":"+login.getPort()+"/XMII/Illuminator?IsTesting=T&QueryTemplate=Default/Som/OCP_ConnPlants/ProductionOrder/SQL_GetShopOrderDetails&Content-Type=text/xml&IllumLoginName="+login.getUser()+"&IllumLoginPassword="+login.getPassword()+"&Param.1="+login.getSite();
		  String SFCURL = "http://"+login.getIp()+":"+login.getPort()+"/XMII/Illuminator?IsTesting=T&QueryTemplate=Default/Som/OCP_ConnPlants/SFC/SQL_GetSFCDetails&Content-Type=text/xml&IllumLoginName="+login.getUser()+"&IllumLoginPassword="+login.getPassword()+"&Param.1="+login.getSite();
		  String OperationURL = "http://"+login.getIp()+":"+login.getPort()+"/XMII/Runner?Transaction=Default/Som/OCP_ConnPlants/Operation/BLS_GetOrderOperationStepDetails&SITE="+login.getSite()+"&FROMDT=10/10/2019%2000:00:00&OutputParameter=XMLResult&Content-type=text/xml&IllumLoginName="+login.getUser()+"&IllumLoginPassword="+login.getPassword();
		  String SiteURL = "http://"+login.getIp()+":"+login.getPort()+"/XMII/Illuminator?QueryTemplate=Default/Som/OCP_ConnPlants/Site/SQL_GetSiteDetails&IsTesting=T&Content-Type=text/xml&IllumLoginName="+login.getUser()+"&IllumLoginPassword="+login.getPassword();
		  
		  
		  try {
			login.setStringURL(new GetMIIResponse().executeShopOrderGETService(SOURL));
			login.setStringURL(new GetMIIResponse().executeSFCGETService(SFCURL));
			login.setStringURL(new GetMIIResponse().executeOperationService(OperationURL));
			login.setStringURL(new GetMIIResponse().executeSiteService(SiteURL));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return "welcome";
	  }
	  
	  
	 /* @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public String ipaddress(@PathVariable("id") String id) throws Exception {
	        return "Reply: " + id;
	    }
	  */
	  
	  @PostMapping("/display")
	    public String getMIISchJob(@ModelAttribute Login login, Model model) {
	      
		  List<MIISchJob> listMIISchJobs = new ArrayList<MIISchJob>();
		  
		  //DisplayMIISchJob displayMIIjob = new DisplayMIISchJob();
		  ShowMIISchJobList displayMIIjob = new ShowMIISchJobList();
		  try {
			displayMIIjob.displayMIISchJobs(listMIISchJobs, login.getSite());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  model.addAttribute("miischjobs", listMIISchJobs);
	        
	      return "display";
	    }
	  
	  @PostConstruct
	    public void init() throws Exception {
		  
		/*
		 * List<MIISchJob> listMIISchJobs = new ArrayList<MIISchJob>();
		 * 
		 * //DisplayMIISchJob displayMIIjob = new DisplayMIISchJob(); ShowMIISchJobList
		 * displayMIIjob = new ShowMIISchJobList();
		 * displayMIIjob.displayMIISchJobs(listMIISchJobs);
		 */
		  
	  }
	  

	   
}
