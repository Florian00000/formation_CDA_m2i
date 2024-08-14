package com.example.demo_basic_hexagonal.shared.port;

import com.example.demo_basic_hexagonal.shared.dto.CommentDTO;

import java.util.List;

public interface CommentPort {
    List<CommentDTO> get(int bookId);
}
