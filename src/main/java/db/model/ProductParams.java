package db.model;

public class ProductParams {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_PARAMS.ID
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_PARAMS.PARAM_NAME
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    private String paramName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_PARAMS.PRODUCT_ID
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_PARAMS.PARAM_STR_VALUE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    private String paramStrValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_PARAMS.PARAM_NUM_VALUE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    private Integer paramNumValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PRODUCT_PARAMS.PARAM_TYPE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    private String paramType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PRODUCT_PARAMS.ID
     *
     * @return the value of PRODUCT_PARAMS.ID
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PRODUCT_PARAMS.ID
     *
     * @param id the value for PRODUCT_PARAMS.ID
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PRODUCT_PARAMS.PARAM_NAME
     *
     * @return the value of PRODUCT_PARAMS.PARAM_NAME
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PRODUCT_PARAMS.PARAM_NAME
     *
     * @param paramName the value for PRODUCT_PARAMS.PARAM_NAME
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PRODUCT_PARAMS.PRODUCT_ID
     *
     * @return the value of PRODUCT_PARAMS.PRODUCT_ID
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PRODUCT_PARAMS.PRODUCT_ID
     *
     * @param productId the value for PRODUCT_PARAMS.PRODUCT_ID
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PRODUCT_PARAMS.PARAM_STR_VALUE
     *
     * @return the value of PRODUCT_PARAMS.PARAM_STR_VALUE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public String getParamStrValue() {
        return paramStrValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PRODUCT_PARAMS.PARAM_STR_VALUE
     *
     * @param paramStrValue the value for PRODUCT_PARAMS.PARAM_STR_VALUE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public void setParamStrValue(String paramStrValue) {
        this.paramStrValue = paramStrValue == null ? null : paramStrValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PRODUCT_PARAMS.PARAM_NUM_VALUE
     *
     * @return the value of PRODUCT_PARAMS.PARAM_NUM_VALUE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public Integer getParamNumValue() {
        return paramNumValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PRODUCT_PARAMS.PARAM_NUM_VALUE
     *
     * @param paramNumValue the value for PRODUCT_PARAMS.PARAM_NUM_VALUE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public void setParamNumValue(Integer paramNumValue) {
        this.paramNumValue = paramNumValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PRODUCT_PARAMS.PARAM_TYPE
     *
     * @return the value of PRODUCT_PARAMS.PARAM_TYPE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PRODUCT_PARAMS.PARAM_TYPE
     *
     * @param paramType the value for PRODUCT_PARAMS.PARAM_TYPE
     *
     * @mbg.generated Wed Sep 08 18:03:54 MSK 2021
     */
    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }
}