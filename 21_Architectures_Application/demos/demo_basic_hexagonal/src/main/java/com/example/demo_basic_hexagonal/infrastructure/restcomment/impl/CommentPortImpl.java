package com.example.demo_basic_hexagonal.infrastructure.restcomment.impl;

import com.example.demo_basic_hexagonal.infrastructure.restcomment.config.RestClient;
import com.example.demo_basic_hexagonal.shared.dto.CommentDTO;
import com.example.demo_basic_hexagonal.shared.port.CommentPort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentPortImpl implements CommentPort {
    private final RestClient<CommentDTO[], CommentDTO> restClient;

    public CommentPortImpl(RestClient<CommentDTO[], CommentDTO> restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<CommentDTO> get(int bookId) {
        return Arrays.stream(restClient.get("comments/"+bookId, CommentDTO[].class)).toList();
    }
}
