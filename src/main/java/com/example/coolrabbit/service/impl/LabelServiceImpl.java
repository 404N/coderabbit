package com.example.coolrabbit.service.impl;

import com.example.coolrabbit.dao.LabelMapper;
import com.example.coolrabbit.entity.Label;
import com.example.coolrabbit.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LabelServiceImpl implements LabelService {
    final LabelMapper labelMapper;

    public LabelServiceImpl(LabelMapper labelMapper) {
        this.labelMapper = labelMapper;
    }

    @Override
    public List<Label> getAllLabel() {
        return labelMapper.selectAll();
    }
}
