package com.grillo.edx.artapi.data.bean.mapper;

import android.util.Log;

import com.grillo.edx.artapi.data.bean.ListResponseDto;
import com.grillo.edx.artapi.data.bean.PaintingResponseDto;
import com.grillo.edx.artapi.data.bean.PaintingsResponseDto;
import com.grillo.edx.artapi.domain.bean.Painting;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PaintingsResponseDtoMapper {

    @Inject
    public PaintingsResponseDtoMapper() {
    }

    public List<Painting> toBusinessObjects(PaintingsResponseDto dtos) {
        List<Painting> businessObjects = null;
        if (dtos != null) {
            ListResponseDto<PaintingResponseDto> data = dtos.getData();

            if (data != null) {

                List<PaintingResponseDto> results = data.getResults();

                if (results != null && !results.isEmpty()) {
                    businessObjects = new ArrayList<>();
                    for (PaintingResponseDto dto : results) {
                        businessObjects.add(PaintingReponseDtoMapper.toBusinessObject(dto));
                    }
                }
            }

        }

        return businessObjects;
    }

}
