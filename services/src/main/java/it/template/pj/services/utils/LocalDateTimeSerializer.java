/**
 * 
 */
package it.template.pj.services.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * @author nicola.cremaschini
 *
 */
public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2846781803950845892L;

	public LocalDateTimeSerializer(){
        super(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        gen.writeString(value.format(DateTimeFormatter.ISO_DATE_TIME));
    }

}
