package com.example.dataingestionservice.service;


import com.example.dataingestionservice.exceptions.TokenRefreshException;
import com.example.dataingestionservice.models.Person;
import com.example.dataingestionservice.models.RefreshToken;
import com.example.dataingestionservice.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    @Value("${refreshtoken.lifetime}")
    private Long refreshTokenDurationMin;
    private final PersonService personService;
    private final RefreshTokenRepository refreshTokenRepository;
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
    public RefreshToken createRefreshToken(Person person) {
        Optional<RefreshToken> existingToken = refreshTokenRepository.findByPerson(person);
        existingToken.ifPresent(refreshTokenRepository::delete);
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setPerson(person);
        refreshToken.setExpiryDate(Instant.now().plus(Duration.ofMinutes(refreshTokenDurationMin)));
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }
        return token;
    }
    @Transactional
    public int deleteByUserEmail(String username) {
        return refreshTokenRepository.deleteByPerson(personService.findByUsername(username));
    }
}