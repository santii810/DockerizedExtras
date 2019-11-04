package com.sgomez.springboot.extras.Extras.services;

import com.sgomez.springboot.extras.Extras.exceptions.ResourceNotFoundException;
import com.sgomez.springboot.extras.Extras.models.ExtraEntity;
import com.sgomez.springboot.extras.Extras.models.LocalEntity;
import com.sgomez.springboot.extras.Extras.models.UserEntity;
import com.sgomez.springboot.extras.Extras.repositories.ExtraRepository;
import com.sgomez.springboot.extras.Extras.repositories.LocalRepository;
import com.sgomez.springboot.extras.Extras.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class ExtraService {
    @Autowired
    ExtraRepository extraRepository;
    @Autowired
    LocalRepository localRepository;
    @Autowired
    UserRepository userRepository;

    public List<ExtraEntity> findAll() {
        return extraRepository.findAll();
    }

    public ExtraEntity save(ExtraEntity extra) {
        return extraRepository.save(extra);
    }

    public ExtraEntity delete(Integer id) {
        Optional<ExtraEntity> extra = extraRepository.findById(id);

        if (!extra.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Dont found extra with id = " + id
            );
        }
        extraRepository.delete(extra.get());
        return extra.get();
    }


    public Optional<ExtraEntity> findById(int id) {
        return extraRepository.findById(id);
    }

    public ExtraEntity update(int id, ExtraEntity details) {
        ExtraEntity extra = extraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Extra", "id", id));

        if (details.getUser() != null) {
            int userId = details.getUser().getId();
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
            extra.setUser(user);
        }
        if (details.getLocal() != null) {
            int localId = details.getLocal().getId();
            LocalEntity local = localRepository.findById(localId)
                    .orElseThrow(() -> new ResourceNotFoundException("Local", "id", localId));
            extra.setLocal(local);
        }

        ExtraEntity updatedExtra = extraRepository.save(extra);
        return updatedExtra;
    }
}
