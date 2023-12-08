package ecommerce.service;

import ecommerce.entity.Image;

import java.util.List;

public interface IImageService {
    List<Image> findByProductId(Long id);
}
