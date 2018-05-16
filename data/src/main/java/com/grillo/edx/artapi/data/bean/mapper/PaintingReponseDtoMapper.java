package com.grillo.edx.artapi.data.bean.mapper;

import android.util.Log;

import com.grillo.edx.artapi.data.bean.PaintingResponseDto;
import com.grillo.edx.artapi.domain.bean.Painting;

public class PaintingReponseDtoMapper {

    private PaintingReponseDtoMapper() {
    }

    public static Painting toBusinessObject(PaintingResponseDto dto) {
        Painting businessObject = null;
        if (dto != null) {

            businessObject = new Painting();
            businessObject.setIdServer(dto.getId());
            businessObject.setUrl(dto.getUrl());
            businessObject.setName(dto.getName());
            businessObject.setAuthor(dto.getAuthor());
            businessObject.setYear(dto.getYear());
            businessObject.setDescription(dto.getDescription());
        }
        return businessObject;
    }

}
