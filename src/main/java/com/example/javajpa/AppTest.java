package com.example.javajpa;

import com.example.javajpa.domain.entities.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class AppTest {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;

        entityManagerFactory = Persistence.createEntityManagerFactory("IFPR_AULA_JPA"); // nome no arquivo persistence.xml

        entityManager = entityManagerFactory.createEntityManager();


        //********
        entityManager.getTransaction().begin();

        Veiculo v1 = new Veiculo();

        v1.setModelo("Fusca");
        v1.setFabricante("VW");
        v1.setAnoModelo(1970);
        v1.setAnoFabricacao(1979);
        v1.setValor(new BigDecimal("5000.00"));

        entityManager.persist(v1);

        //********
        entityManager.getTransaction().commit();


        // Busca

        Veiculo v2 = entityManager.find(Veiculo.class, 4L);

        System.out.println(v2.getModelo() + " - " + v2.getFabricante());

    }
}
