package com.di;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ContainerServiceTest {

    @Test
    void repositoryTest() {
        CardRepository cardRepository = ContainerService.getInstance(CardRepository.class);
        assertNotNull(cardRepository);
    }

    @Test
    void serviceTest() {
        CardService cardService = ContainerService.getInstance(CardService.class);
        assertNotNull(cardService);
        assertNotNull(cardService.cardRepository);
    }
}