package gleideveloper.com.br.javaavancado.util;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gleides on 31/03/17.
 */
public class ConverteDate implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Date date = (Date) o;
        String dateFormated = new SimpleDateFormat("dd/MM/yyyy").format(date);
        hierarchicalStreamWriter.setValue(dateFormated);
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Date date = null;
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = simpleDateFormat.parse(hierarchicalStreamReader.getValue());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Date.class);
    }
}
