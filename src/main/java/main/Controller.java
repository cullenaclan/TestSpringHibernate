package main;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.PolicyDAO;
import model.Policy;

@RestController
public class Controller 
{
		@Autowired PolicyDAO policyDao;
	
		@RequestMapping(value = "/policy/get", method = RequestMethod.GET)
		public ResponseEntity<Policy> get(@RequestParam("id") int id)
		{
			
			Policy policy = policyDao.get(id);
			
			if(policy == null)
				return new ResponseEntity<Policy>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<Policy>(policy, HttpStatus.OK);
			
		}
		
		
		@RequestMapping(value = "/policy/save", method = RequestMethod.POST)
		public ResponseEntity<Object> save(@Valid @RequestBody Policy policy)
		{
			try
			{
				policyDao.save(policy);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		
		
		@RequestMapping(value = "/policy/delete/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Object> delete(@PathVariable int id)
		{
			
			try
			{
				policyDao.delete(id);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<Object>(HttpStatus.OK);
		
		}
	
		
		@RequestMapping(value = "/policy/update/", method = RequestMethod.PUT)
		public ResponseEntity<Object> update(@RequestBody Policy policy)
		{
			try
			{
				policyDao.update(policy);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		
		
		@RequestMapping(value = "/policy/list", method = RequestMethod.GET)
		public ResponseEntity<List<Policy>> list()
		{
			List<Policy> policy = policyDao.list();
			
			if(policy == null)
				return new ResponseEntity<List<Policy>>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<List<Policy>>(policy, HttpStatus.OK);
		}
		
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
//		
//		PolicyDAO policyDAO = context.getBean(PolicyDAO.class);
//		
//		Policy policy = new Policy();
//		policy.setId(5);
//		policy.setName("AAA");
//		
//		policy.setName("Cullen"); 
//		policyDAO.save(policy);
//		
//		policyDAO.delete(policy);
//		policyDAO.update(policy);
//		
//		System.out.println("Policy::"+policy);
//		
//		List<Policy> list = policyDAO.list();
//		
//		for(Policy p : list){
//			System.out.println("Policy List::"+p);
//		}
//		//close resources
//		context.close();	
		
	
}
