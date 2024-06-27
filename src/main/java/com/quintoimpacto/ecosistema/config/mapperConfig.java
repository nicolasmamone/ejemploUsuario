package com.quintoimpacto.ecosistema.config;

import com.quintoimpacto.ecosistema.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapperConfig {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        // Configuración personalizada para mapear listas de mensajes
        // modelMapper.createTypeMap(Usuario.class, UsuarioResponse.class);

        return new ModelMapper();
    }
}
