package com.danielfreitassc.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.danielfreitassc.backend.models.Sequence;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public Long generateSequence(String seqName) {
        Sequence counter = mongoOperations.findAndModify(
            Query.query(where("_id").is(seqName)),
            new Update().inc("seq", 1),
            options().returnNew(true).upsert(true),
            Sequence.class
        );

        return counter != null ? counter.getSeq() : 1L;
    }
}
