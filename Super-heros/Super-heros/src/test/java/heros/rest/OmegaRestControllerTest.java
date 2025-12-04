package heros.rest;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import heros.model.Omega;
import heros.repo.CompteRepository;
import heros.repo.HerosRepository;
import heros.service.HerosService;

@WebMvcTest(OmegaRestController.class)
@EnableMethodSecurity(prePostEnabled = true)

public class OmegaRestControllerTest {
	private static final String API_URL = "/api/omega";
	private static final int HEROS_ID = 1;
	private static final String HEROS_NOM ="Smith";
	private static final String HEROS_PRENOM ="John";
	private static final String HEROS_ALIAS ="Homelander";
	private final int HEROS_POPULARITE =500;
	private final int HEROS_SANTE =150;
	private final double HEROS_SALAIRE =500;
	private final double HEROS_COUT_CREATION =3;
	private final int HEROS_EXPERIENCE =100;
	private final double HEROS_DEGATS =400;
	private final int HEROS_MOTIVATION =100;
	private static final String API_URL_BY_ID = API_URL + "/" + HEROS_ID;
	private static final String API_URL_BY_ALIAS = API_URL + "/alias/" + HEROS_ALIAS;
	
	 @MockitoBean
	private HerosRepository herosRepository;
	
	 @MockitoBean
	private CompteRepository compteRepository;
	
	 @MockitoBean
    private HerosService herosService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldFindAllStatusUnauthorized() throws Exception {
		// given

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL));

		// then
		result.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}

	@Test
	@WithMockUser
	void shouldFindAllStatusOk() throws Exception {
		// given

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL));

		// then
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*@Test
	@WithMockUser
	void shouldFindAllUseRepositoryFindAll() throws Exception {
		// given

		// when
		this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL));

		// then
		Mockito.verify(this.herosRepository).findAll();
	}*/

	/*@Test
	@WithMockUser
	void shouldFindAllReturnAttributes() throws Exception {
		// given
		Omega o = new Omega();

		o.setId(1);
		o.setNom(HEROS_NOM);
		o.setPrenom(HEROS_PRENOM);
		o.setAlias(HEROS_ALIAS);
		o.setPopularite(HEROS_POPULARITE);
		o.setSante(HEROS_SANTE);
		o.setSalaire(HEROS_SALAIRE);
		o.setCoutCreation(HEROS_COUT_CREATION);
		o.setExperience(HEROS_EXPERIENCE);
		o.setDegats(HEROS_DEGATS);
		o.setMotivation(HEROS_MOTIVATION);

		Mockito.when(this.herosRepository.findAll()).thenReturn(List.of(o));

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL));

		// then
		result.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.nom").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.prenom").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.alias").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.popularite").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.sante").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.salaire").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutCreation").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutExperience").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutDegats").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutMotivation").exists());
	}

	@Test
	void shouldFindByIdStatusUnauthorized() throws Exception {
		// given

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ID));

		// then
		result.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}*/

	/*@Test
	@WithMockUser
	void shouldFindByIdStatusOk() throws Exception {
		// given
		Mockito.when(this.herosRepository.findById(HEROS_ID)).thenReturn(Optional.of(new Omega()));

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ID));

		// then
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}*/

	/*@Test
	@WithMockUser
	void shouldFindByIdUseDaoFindById() throws Exception {
		// given
		Mockito.when(this.herosRepository.findById(HEROS_ID)).thenReturn(Optional.of(new Omega()));

		// when
		this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ID));

		// then
		Mockito.verify(this.herosRepository).findById(HEROS_ID);
	}*/

	@Test
	@WithMockUser
	void shouldFindByIdStatusNotFoundWhenIdNotFound() throws Exception {
		// given

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ID));
		Mockito.when(this.herosRepository.findById(HEROS_ID)).thenReturn(Optional.empty());
		// then
		result.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	/*@Test
	@WithMockUser
	void shouldFindByIdReturnAttributes() throws Exception {
		// given
		Omega o = new Omega();

		o.setId(HEROS_ID);
		o.setNom(HEROS_NOM);
		o.setPrenom(HEROS_PRENOM);
		o.setAlias(HEROS_ALIAS);
		o.setPopularite(HEROS_POPULARITE);
		o.setSante(HEROS_SANTE);
		o.setSalaire(HEROS_SALAIRE);
		o.setCoutCreation(HEROS_COUT_CREATION);
		o.setExperience(HEROS_EXPERIENCE);
		o.setDegats(HEROS_DEGATS);
		o.setMotivation(HEROS_MOTIVATION);
		
		System.out.println();
		
		Mockito.when(this.herosRepository.findById(HEROS_ID)).thenReturn(Optional.of(o));

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ID));

		// then
		result.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.nom").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.prenom").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.alias").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.popularite").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.sante").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.salaire").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutCreation").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutExperience").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutDegats").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutMotivation").exists());
	
	}*/

	@Test
	void shouldFindByAliasStatusUnauthorized() throws Exception {
		// given

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ALIAS));

		// then
		result.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}


	/*@Test
	@WithMockUser
	void shouldFindByAliasStatusOk() throws Exception {
		// given

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ALIAS));

		// then
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}*/

	/*@Test
	@WithMockUser
	void shouldFindByAliasUseRepositoryFindByAlias() throws Exception {
		// given

		// when
		this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ALIAS));

		// then
		Mockito.verify(this.herosRepository).findByAlias(HEROS_ALIAS);
	}*/

	/*@Test
	@WithMockUser
	void shouldFindByNameReturnAttributes() throws Exception {
		// given
		Omega o = new Omega();

		o.setId(HEROS_ID);
		o.setNom(HEROS_NOM);
		o.setPrenom(HEROS_PRENOM);
		o.setAlias(HEROS_ALIAS);
		o.setPopularite(HEROS_POPULARITE);
		o.setSante(HEROS_SANTE);
		o.setSalaire(HEROS_SALAIRE);
		o.setCoutCreation(HEROS_COUT_CREATION);
		o.setExperience(HEROS_EXPERIENCE);
		o.setDegats(HEROS_DEGATS);
		o.setMotivation(HEROS_MOTIVATION);
		Mockito.when(this.herosRepository.findByAlias(HEROS_ALIAS)).thenReturn((o));

		// when
		ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(API_URL_BY_ALIAS));

		// then
		result.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.nom").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.prenom").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.alias").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.popularite").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.sante").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.salaire").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutCreation").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutExperience").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutDegats").exists());
		result.andExpect(MockMvcResultMatchers.jsonPath("$.coutMotivation").exists());
	}*/

}
