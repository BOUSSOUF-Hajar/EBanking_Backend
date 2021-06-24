package com.projetJEE.Ebanking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.projetJEE.Ebanking.Dao.AdminRepository;
import com.projetJEE.Ebanking.Dao.AgenceRepository;
import com.projetJEE.Ebanking.Dao.AgentRepository;
import com.projetJEE.Ebanking.Dao.ClientRepository;
import com.projetJEE.Ebanking.Dao.CompteRepository;
import com.projetJEE.Ebanking.Dao.DeviseRepository;
import com.projetJEE.Ebanking.Dao.OperateurRepository;
import com.projetJEE.Ebanking.Dao.OperationRepository;
import com.projetJEE.Ebanking.Dao.RechargeRepository;
import com.projetJEE.Ebanking.Dao.VirementRepository;
import com.projetJEE.Ebanking.entities.Admin;
import com.projetJEE.Ebanking.entities.Agence;
import com.projetJEE.Ebanking.entities.Agent;
import com.projetJEE.Ebanking.entities.Client;
import com.projetJEE.Ebanking.entities.Compte;
import com.projetJEE.Ebanking.entities.Devise;
import com.projetJEE.Ebanking.entities.Operateur;
import com.projetJEE.Ebanking.entities.Operation;
import com.projetJEE.Ebanking.entities.Recharge;
import com.projetJEE.Ebanking.entities.Virement;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class EBankingApplication implements CommandLineRunner {

	@Autowired
	private AgenceRepository agenceR;
	@Autowired
	private ClientRepository clientR;
	@Autowired
	private CompteRepository compteR;
	@Autowired
	private AgentRepository agentR;
	@Autowired
	private AdminRepository adminR;
	@Autowired
	private DeviseRepository deviseR;
	@Autowired
	private RechargeRepository rechargeR;
	@Autowired
	private VirementRepository virementR;
	@Autowired
	private OperateurRepository operateurR;
	@Autowired
	private OperationRepository operationR;
	
	//pour recuperer le id des articles 
	@Autowired
	private RepositoryRestConfiguration rrc;
	
	public static void main(String[] args) {
		SpringApplication.run(EBankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String[] noms={"Lina","Allen","Jones",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
		String[] prenoms={"Marco","Paul","Alain",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
		String[] usernames={"Lina","allen","jones",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
		String[] passwords={"madagascar","allen","jones",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
		
		//pour recuperer le id des articles 
		rrc.exposeIdsFor(Client.class,Compte.class,Agent.class,Virement.class,Agence.class,Operation.class,Operateur.class);
		List<Client>clients=new ArrayList<Client>();
		List<Agent>agents=new ArrayList<Agent>();
		List<Compte>comptes1=new ArrayList<Compte>();
		List<Compte>comptes2=new ArrayList<Compte>();
		List<Compte>comptes3=new ArrayList<Compte>();
		List<Compte>comptes4=new ArrayList<Compte>();
		List<Compte>comptes5=new ArrayList<Compte>();
		List<Compte>comptes6=new ArrayList<Compte>();
		List<Compte>comptes7=new ArrayList<Compte>();
		
		List<List<Compte>>comptes=new ArrayList<List<Compte>>();
		comptes.add(comptes1);
		comptes.add(comptes2);
		comptes.add(comptes3);
		comptes.add(comptes4);
		comptes.add(comptes5);
		comptes.add(comptes6);
		comptes.add(comptes7);
		List<Virement>virements_envoyés1=new ArrayList<Virement>();
		List<Virement>virements_envoyés2=new ArrayList<Virement>();
		List<Virement>virements_envoyés3=new ArrayList<Virement>();
		
		
		List<Virement>virements_recus1=new ArrayList<Virement>();
		List<Virement>virements_recus2=new ArrayList<Virement>();
		List<Virement>virements_recus3=new ArrayList<Virement>();
		
		
		List<Operation>operations1=new ArrayList<Operation>();
		List<Operation>operations2=new ArrayList<Operation>();
		List<Operation>operations3=new ArrayList<Operation>();
		
		List<Recharge>recharges1=new ArrayList<Recharge>();
		List<Recharge>recharges2=new ArrayList<Recharge>();
		List<Recharge>recharges3=new ArrayList<Recharge>();
		
		//creer les client
		for(int i=0;i<noms.length;i++){
			Client c=new Client("oui",null,null,null);
			c.setNom(noms[i]);
			c.setAdresse(RandomString.make(15));
			c.setEmail(RandomString.make(10)+"@gmail.com");
			c.setPrenom(prenoms[i]);
			c.setPassword(passwords[i]);
			c.setCin("MM"+RandomString.make(10));
			c.setUsername(usernames[i]);
			c.setRole("client");
			c.setComptes(comptes.get(i));
			clientR.save(c);
			clients.add(c);
			
		}
		
			//un admin
			Admin admin1=new Admin();
			admin1.setPassword("admin");
			admin1.setNom("Caleta Car");
			admin1.setPrenom("Duje");
			admin1.setAdresse("rue du man");
			admin1.setEmail("iezae@gmail.com");
			admin1.setTelephone("+212 67876787");
			admin1.setUsername("root");
			admin1.setRole("admin");
			//un admin2
			Admin admin2=new Admin();
			admin2.setPassword("password");
			admin2.setNom("Drake");
			admin2.setPrenom("Domen");
			admin2.setAdresse("rue du louvre");
			admin2.setEmail("iefdsfsd@gmail.com");
			admin2.setTelephone("+212 67886787");
			admin2.setUsername("user");
			admin2.setRole("admin");
			adminR.save(admin1);
			adminR.save(admin2);
			//creer une agence
			Agence 	agence1=new Agence(1L,"principale","sidi abbad","+2127837278","663253","agence1@gmail.com",admin1,null,clients);
		//creer des agents
			String[] nomsA={"karl","Allen","Jonzdzes",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
			String[] prenomsA={"marcos","Paul","dqsn",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
			String[] usernamesA={"alain","sddallen","jonesdss",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
			String[] passwordsA={"delon","dssallen","dsjones",RandomString.make(12),RandomString.make(12),RandomString.make(12),RandomString.make(12)};
			for(int i=0;i<nomsA.length;i++){
				Agent agent=new Agent(null,null);
				agent.setPassword(passwordsA[i]);
				agent.setNom(nomsA[i]);
				agent.setPrenom(prenomsA[i]);
				agent.setUsername(usernamesA[i]);
				agent.setRole("agent");
				agents.add(agent);
				agentR.save(agent);
				
				
			}
			agence1.setAgents(agents);
			agenceR.save(agence1);
			for(Agent ag:agents){
				ag.setAgence(agence1);
				ag.setCreationAdmin(admin2);
				agentR.save(ag);
			}
		
		//creer les comptes 
			//devise
			Devise d=new Devise(1L,"USD","Dollar","english","@66576","ISO 3166","B65657","US",null,admin2,null,admin1);
			Devise d2=new Devise(2L,"INR","Roupie","english","@6767'","ISO 3366","B65657","IN",null,admin2,null,admin1);
			Devise d3=new Devise(3L,"EUR","Euro","francais","@766767","ISO 3266","B65657","EU",null,admin2,null,admin1);
			Devise d4=new Devise(4L,"DEM","Deutshe Mark","allemand","@76767","ISO 3162","B65657","DE",null,admin2,null,admin1);
			deviseR.save(d);
			deviseR.save(d2);
			deviseR.save(d3);
			deviseR.save(d4);
			
				
			Compte compte=new Compte(1L,RandomString.make(10),"epargne",5000.0,d,null,clients.get(0),agents.get(1),null,null,null,null);
			comptes1.add(compte);
			clients.get(0).setComptes(comptes1);
			clients.get(0).setAgence(agence1);
			clients.get(0).setCreationAgent(agents.get(0));
			
		clientR.save(clients.get(0));	
				
				Compte compte2=new Compte(2L,RandomString.make(10),"epargne",9000.0,d2,null,clients.get(1),agents.get(1),null,null,null,null);
				Compte compte2_2=new Compte(3L,RandomString.make(10),"courant",2000.0,d2,null,clients.get(1),agents.get(0),null,null,null,null);
				Compte compte2_3=new Compte(4L,RandomString.make(10),"credit",3000.0,d2,null,clients.get(1),agents.get(2),null,null,null,null);
				comptes2.add(compte2);
				comptes2.add(compte2_2);
				comptes2.add(compte2_3);
				clients.get(1).setComptes(comptes2);
				clients.get(1).setAgence(agence1);
				clients.get(1).setCreationAgent(agents.get(1));
			clientR.save(clients.get(1));
			
			
			Compte compte3=new Compte(5L,RandomString.make(10),"epargne",4000.0,d3,null,clients.get(2),agents.get(2),null,null,null,null);
			comptes3.add(compte3);
			clients.get(2).setComptes(comptes3);
			clients.get(2).setAgence(agence1);
			clients.get(2).setCreationAgent(agents.get(2));
			
		clientR.save(clients.get(2));
		
		for (int j=3;j<clients.size();j++){
			Compte nv_compte=new Compte((long)6+j,RandomString.make(10),"epargne",2000.0*j,d,null,clients.get(j),agents.get(1),null,null,null,null);
			comptes.get(j).add(nv_compte);
			clients.get(j).setComptes(comptes.get(j));
			clients.get(j).setAgence(agence1);
			clients.get(j).setCreationAgent(agents.get(0));
			clientR.save(clients.get(j));
		}
			
			
		
				
			
			//Virement 
			Virement v1=new Virement(1L,compte,compte3,null,1200.0,1200.0);
			Virement v2=new Virement(2L,compte,compte2,null,1500.0,1500.0);
			v1.setDate(LocalDateTime.now());
			v2.setDate(LocalDateTime.now());
			virementR.save(v1);
			virementR.save(v2);
			
			
			
			//operation
			Operation op1=new Operation(1L,compte,null,2000.0,1999.0,"Versement",d);
			Operation op2=new Operation(2L,compte,null,3000.0,2999.0,"Retrait",d2);
			Operation op3=new Operation(3L,compte,null,4000.0,3999.0,"Versement",d3);
			Operation op4=new Operation(4L,compte2,null,2000.0,1999.0,"Versement",d);
			Operation op5=new Operation(5L,compte3,null,2000.0,1999.0,"Versement",d);
			operations1.add(op1);
			operations1.add(op2);
			operations1.add(op3);
			operations2.add(op4);
			operations3.add(op5);
			
			virements_envoyés1.add(v1);
			virements_envoyés1.add(v2);
			
			
			virements_recus2.add(v2);
			virements_recus3.add(v1);
			
				
				compte.setVirementsEnvoyes(virements_envoyés1);
				compte2.setVirementsRecus(virements_recus2);
				compte3.setVirementsRecus(virements_recus3);
				compte.setOperations(operations1);
				compte2.setOperations(operations2);
				compte3.setOperations(operations3);
			operationR.save(op1);
			operationR.save(op2);
			operationR.save(op3);
			operationR.save(op4);
			operationR.save(op5);
			
			
			
		
	
		Operateur o1=new Operateur();
		o1.setRole(RandomString.make(10));
		o1.setUsername(RandomString.make(10));
		o1.setPassword(RandomString.make(10));
		o1.setNom("Miller");
		o1.setEmail("op1@gmail.com");
		o1.setAdresse("foire au saucisses");
		o1.setTelephone("+2120998998889");
		operateurR.save(o1);
		//comptes des operateurs
		List<Compte>comptes_operateur1=new ArrayList<Compte>();
				
		Compte compte_operateur1=new Compte(20L,RandomString.make(10),"epargne",5000.0,d,null,o1,agents.get(1),null,null,null,null);
		compteR.save(compte_operateur1);
		comptes_operateur1.add(compte_operateur1);
		o1.setComptes(comptes_operateur1);
		o1.setAgence(agence1);
		o1.setCreationAgent(agents.get(0));
		
		Operateur o2=new Operateur();
		o2.setRole(RandomString.make(10));
		o2.setNom("Morris");
		o2.setEmail("op2@gmail.com");
		o2.setAdresse("rue du man");
		o2.setTelephone("+2120998998989");
		o2.setUsername(RandomString.make(10));
		o2.setPassword(RandomString.make(10));
		o1.setCin(RandomString.make(15));
		o2.setCin(RandomString.make(15));
		Operateur o3=new Operateur();
		o3.setRole(RandomString.make(10));
		o3.setNom("Zineb");
		o3.setEmail("op3@gmail.com");
		o3.setAdresse("rue du loup");
		o3.setTelephone("+2120933998989");
		o3.setUsername(RandomString.make(10));
		o3.setPassword(RandomString.make(10));
		o3.setCin(RandomString.make(15));
		
		Operateur o4=new Operateur();
		o4.setRole(RandomString.make(10));
		o4.setNom("AL Rezanhi");
		o4.setEmail("op4@gmail.com");
		o4.setAdresse("rue du louvre");
		o4.setTelephone("+2120998998939");
		o4.setUsername(RandomString.make(10));
		o4.setPassword(RandomString.make(10));
		o4.setCin(RandomString.make(15));
		
		operateurR.save(o1);
		operateurR.save(o2);
		operateurR.save(o3);
		operateurR.save(o4);
		
		Recharge r1=new Recharge(1L,3000.0,2950.0,d2,"+212 7668733",LocalDateTime.now(),compte,o1);
		Recharge r2=new Recharge(2L,9000.0,8950.0,d3,"+212 7128733",LocalDateTime.now(),compte,o1);
		Recharge r3=new Recharge(3L,5000.0,4950.0,d,"+212 7228733",LocalDateTime.now(),compte3,o1);
		Recharge r4=new Recharge(4L,4000.0,3950.0,d4,"+212 7662233",LocalDateTime.now(),compte2,o1);
		rechargeR.save(r1);
		rechargeR.save(r2);
		rechargeR.save(r3);
		rechargeR.save(r4);
		recharges1.add(r1);
		recharges1.add(r2);
		recharges2.add(r4);
		recharges3.add(r3);
		
		
		
		compteR.save(compte);
		compteR.save(compte3);
		compteR.save(compte2);
		
		//http://localhost:4200/client/:1/accountForm
		
	
		
		
		


}}
