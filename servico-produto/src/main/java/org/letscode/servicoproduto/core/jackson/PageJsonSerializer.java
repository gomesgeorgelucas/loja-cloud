package org.letscode.servicoproduto.core.jackson;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent //component spring que fornece uma implementaão de serializado de deserilizador, do tipo page
public class PageJsonSerializer extends JsonSerializer<Page<?>> { //? qlq tipo de model pega config página

	@Override
	public void serialize(Page<?> page, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();//começa para mim um objeto
		gen.writeObjectField("content", page.getContent()); //escreve uma properiedade de objeto, conteudo dela e o conteudo do page, e traz ele pro content 
		gen.writeNumberField("size", page.getSize()); //tamanho da pagina dos elementos que fica em cada pagina
		gen.writeNumberField("totalElements", page.getTotalElements()); //total de elementos
		gen.writeNumberField("totalPages", page.getTotalPages());//total de páginas
		gen.writeNumberField("number", page.getNumber()); //em qual página se encontra
		
		gen.writeEndObject(); 
	}
}