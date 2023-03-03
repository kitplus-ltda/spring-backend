package br.com.kitplus.repository.model;

import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.repository.entity.ProductImagesEntity;
import br.com.kitplus.repository.entity.ProductVideosEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductEntityConverterDTO {

    public ProductEntity getProductEntity(@NotNull ProductDTO dto) {
        ProductEntity ent = new ProductEntity();
        ProductCategoriesEntity cat = new ProductCategoriesEntity();
        List<ProductImagesEntity> img = new ArrayList<>();
        List<ProductVideosEntity> vdo = new ArrayList<>();

        for (int i = 0; i < dto.getProductImages().size(); i++) {
            ProductImagesEntity imgEnt = new ProductImagesEntity();
            imgEnt.setImage(dto.getProductImages().get(i).getUrl());
            img.add(imgEnt);
        }
        for (int i = 0; i < dto.getProductVideos().size(); i++) {
            ProductVideosEntity productVideosEntity = new ProductVideosEntity();
            productVideosEntity.setVideo(dto.getProductVideos().get(i).getUrl());
            vdo.add(productVideosEntity);
        }

        ent.setAltura(dto.getAltura());
        ent.setCaracteristicas(dto.getCaracteristicas());
        ent.setComprimento(dto.getComprimento());
        ent.setDescricao(dto.getDescricao());
        ent.setDetalhes(dto.getDetalhes());
        ent.setLargura(dto.getLargura());
        ent.setNome(dto.getNome());
        ent.setPeso(dto.getPeso());
        ent.setPreco(dto.getPreco());
        ent.setPromocional(dto.getPromocional());
        ent.setQuantidade(dto.getQuantidade());
        cat.setCategory_id(dto.getCategory_id());
        ent.setCategory(cat);
        ent.setProductImages(img);
        ent.setProductVideos(vdo);

        return ent;
    }
}
