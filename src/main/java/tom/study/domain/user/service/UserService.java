package tom.study.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import tom.study.domain.user.model.entity.Authority;
import tom.study.domain.user.model.entity.Favorites;
import tom.study.domain.user.model.entity.User;
import tom.study.domain.user.repository.AuthorityRepository;
import tom.study.domain.user.repository.FavoritesRepository;
import tom.study.domain.user.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final FavoritesRepository favoritesRepository;
    private final AuthorityRepository authorityRepository;
    //public User createUser()

    public Favorites addFavorites(Favorites favorites) {
        return favoritesRepository.save(favorites);
    }

    public void delFavorites(Favorites favorites) {
        favoritesRepository.delete(favorites);
    }

    public User signupUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new DuplicateKeyException("username is already exist");
        }
        User createdUser = userRepository.save(user);
        Authority authority = new Authority();
        authority.setUser(createdUser);
        authority.setUserName(createdUser.getUsername());
        authority.setAuthority(Authority.Authority_Type.ROLE_USER);
        authorityRepository.save(authority);
        return createdUser;
    }

    public void empowermentUser(String userName) {
        Optional<Authority> authority = authorityRepository.findByUserName(userName);
        authority.ifPresent(auth -> {
            if (Objects.equals(auth.getAuthority(), Authority.Authority_Type.ROLE_USER)) {
                auth.setAuthority(Authority.Authority_Type.ROLE_ADMIN);
            } else {
                auth.setAuthority(Authority.Authority_Type.ROLE_USER);
            }
            authorityRepository.save(auth);
        });
    }
}
