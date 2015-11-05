package com.askfast.strowger.util;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JOM {
    private static final ObjectMapper       MAPPER  = createInstance();

    /**
     * Instantiates a new jom.
     */
    protected JOM() {}

    /**
     * Gets the single instance of JOM.
     * 
     * @return single instance of JOM
     */
    public static ObjectMapper getInstance() {
            return MAPPER;
    }

    /**
     * Creates the object node.
     * 
     * @return the object node
     */
    public static ObjectNode createObjectNode() {
            return getInstance().createObjectNode();
    }

    /**
     * Creates the array node.
     * 
     * @return the array node
     */
    public static ArrayNode createArrayNode() {
            return getInstance().createArrayNode();
    }

    /**
     * Creates the null node.
     * 
     * @return the null node
     */
    public static NullNode createNullNode() {
            return NullNode.getInstance();
    }

    /**
     * Creates the instance.
     * 
     * @return the object mapper
     */
    private static synchronized ObjectMapper createInstance() {
            final ObjectMapper mapper = new ObjectMapper();

            mapper.setNodeFactory(new JsonNodeFactory() {
                    private static final long       serialVersionUID        = -1340917885113347742L;

                    @Override
                    public ObjectNode objectNode() {
                            return new ObjectNode(this,
                                            new LinkedHashMap<String, JsonNode>(2));
                    }
            });

            // set configuration
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                            false);
            mapper.configure(
                            DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, false);
            mapper.getFactory().configure(
                            JsonFactory.Feature.CANONICALIZE_FIELD_NAMES, false);

            // Needed for o.a. JsonFileState
            mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
            mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);

            // Convenient for JSON configuration documents
            mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
            mapper.configure(JsonParser.Feature.ALLOW_YAML_COMMENTS, true);
            
            mapper.setSerializationInclusion(Include.NON_NULL);

            SimpleModule bitSetModule = new SimpleModule("BitSetModule",
                            new Version(1, 0, 0, null, null, null));
            mapper.registerModule(bitSetModule);

            SimpleModule uriModule = new SimpleModule("UriModule", new Version(1,
                            0, 0, null, null, null));
            mapper.registerModule(uriModule);

            return mapper;
    }
}
