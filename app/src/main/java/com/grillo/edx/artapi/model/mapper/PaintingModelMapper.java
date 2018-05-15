package com.grillo.edx.artapi.model.mapper;

import com.grillo.edx.artapi.domain.bean.Painting;
import com.grillo.edx.artapi.model.PaintingModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class PaintingModelMapper {

    @Inject
    public PaintingModelMapper() {
    }

    public PaintingModel toModel(Painting bo) {
        PaintingModel model = null;
        if (bo != null) {
            model = new PaintingModel();
            model.setIdServer(bo.getIdServer());
            model.setUrl(bo.getUrl());
            model.setName(bo.getName());
            model.setAuthor(bo.getAuthor());
            model.setYear(bo.getYear());
            model.setDescription(bo.getDescription());
        }
        return model;
    }

    public List<PaintingModel> toModel(Collection<Painting> bos) {
        List<PaintingModel> models = null;
        if (bos != null && !bos.isEmpty()) {
            models = new ArrayList<>(bos.size());
            for (Painting bo : bos) {
                models.add(toModel(bo));
            }
        }
        return models;
    }

}
