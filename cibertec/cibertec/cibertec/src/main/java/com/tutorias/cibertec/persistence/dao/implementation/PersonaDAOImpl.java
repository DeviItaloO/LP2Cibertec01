package com.tutorias.cibertec.persistence.dao.implementation;

import com.tutorias.cibertec.persistence.dao.interfaces.IPersonaDAO;

import com.tutorias.cibertec.persistence.entity.PersonaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDAOImpl implements IPersonaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<PersonaEntity> findAll() {
        return this.em.createQuery("SELECT u FROM PersonaEntity u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonaEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(PersonaEntity.class, id));
    }

    @Override
    @Transactional
    public void savePersona(PersonaEntity personaEntity) {
        this.em.persist(personaEntity);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updatePersona(PersonaEntity personaEntity) {
        this.em.merge(personaEntity);
    }

    @Override
    @Transactional
    public void deletePersona(PersonaEntity personaEntity) {
        this.em.remove(personaEntity);
    }

}
