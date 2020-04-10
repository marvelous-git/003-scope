package zw.co.econet;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import zw.co.econet.model.Speaker;
import zw.co.econet.repository.SpeakerRepository;
import zw.co.econet.repository.SpeakerRepositoryImp;
import zw.co.econet.service.SpeakerService;
import zw.co.econet.service.SpeakerServiceImp;

@Configuration
public class AppConfig {

    @Bean(name="service")
    @Scope("singleton")
    public SpeakerService getSpeakerService(){
        SpeakerServiceImp service = new SpeakerServiceImp();
        service.setRepo(getSpeakerRepository());
        return service;
    }

    @Bean(name = "repo")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public SpeakerRepository getSpeakerRepository(){
      //  SpeakerRepositoryImp repo = new SpeakerRepositoryImp();
      //  repo.setSpeaker(getSpeaker());
        SpeakerRepositoryImp repo = new SpeakerRepositoryImp(getSpeaker());
        return repo;
    }
    @Bean(name = "speaker")
    public Speaker getSpeaker(){
        return new Speaker();
    }
}
