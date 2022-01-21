package com.enterprise.netmovies.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserListener extends AbstractMongoEventListener<User> {
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public UserListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public void onBeforeConvert(BeforeConvertEvent<User> event){
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
        }
    }
}
