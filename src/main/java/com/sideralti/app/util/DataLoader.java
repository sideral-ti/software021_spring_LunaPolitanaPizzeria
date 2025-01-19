package com.sideralti.app.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sideralti.app.model.entity.UserEntity;
import com.sideralti.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        TypeReference<List<UserEntity>> typeReference = new TypeReference<List<UserEntity>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/jason/data-templates.json");

        try {
            List<UserEntity> entitiesList = mapper.readValue(inputStream, typeReference);
            userRepository.saveAll(entitiesList);
            System.out.println("Datos cargados exitosamente!");
        } catch (Exception e) {
            System.out.println("Error al cargar los datos iniciales: " + e.getMessage());
            throw e;
        }
    }
}