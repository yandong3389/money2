package d.money.pojo.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserProxyApplicationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer mysqlOffset;

    protected Integer mysqlLength;

    public UserProxyApplicationInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setMysqlOffset(Integer mysqlOffset) {
        this.mysqlOffset=mysqlOffset;
    }

    public Integer getMysqlOffset() {
        return mysqlOffset;
    }

    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength=mysqlLength;
    }

    public Integer getMysqlLength() {
        return mysqlLength;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagIsNull() {
            addCriterion("up_proxy_flag is null");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagIsNotNull() {
            addCriterion("up_proxy_flag is not null");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagEqualTo(String value) {
            addCriterion("up_proxy_flag =", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagNotEqualTo(String value) {
            addCriterion("up_proxy_flag <>", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagGreaterThan(String value) {
            addCriterion("up_proxy_flag >", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("up_proxy_flag >=", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagLessThan(String value) {
            addCriterion("up_proxy_flag <", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagLessThanOrEqualTo(String value) {
            addCriterion("up_proxy_flag <=", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagLike(String value) {
            addCriterion("up_proxy_flag like", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagNotLike(String value) {
            addCriterion("up_proxy_flag not like", value, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagIn(List<String> values) {
            addCriterion("up_proxy_flag in", values, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagNotIn(List<String> values) {
            addCriterion("up_proxy_flag not in", values, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagBetween(String value1, String value2) {
            addCriterion("up_proxy_flag between", value1, value2, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andUpProxyFlagNotBetween(String value1, String value2) {
            addCriterion("up_proxy_flag not between", value1, value2, "upProxyFlag");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andApproveFlagIsNull() {
            addCriterion("approve_flag is null");
            return (Criteria) this;
        }

        public Criteria andApproveFlagIsNotNull() {
            addCriterion("approve_flag is not null");
            return (Criteria) this;
        }

        public Criteria andApproveFlagEqualTo(String value) {
            addCriterion("approve_flag =", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagNotEqualTo(String value) {
            addCriterion("approve_flag <>", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagGreaterThan(String value) {
            addCriterion("approve_flag >", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagGreaterThanOrEqualTo(String value) {
            addCriterion("approve_flag >=", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagLessThan(String value) {
            addCriterion("approve_flag <", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagLessThanOrEqualTo(String value) {
            addCriterion("approve_flag <=", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagLike(String value) {
            addCriterion("approve_flag like", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagNotLike(String value) {
            addCriterion("approve_flag not like", value, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagIn(List<String> values) {
            addCriterion("approve_flag in", values, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagNotIn(List<String> values) {
            addCriterion("approve_flag not in", values, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagBetween(String value1, String value2) {
            addCriterion("approve_flag between", value1, value2, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveFlagNotBetween(String value1, String value2) {
            addCriterion("approve_flag not between", value1, value2, "approveFlag");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNull() {
            addCriterion("approve_date is null");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNotNull() {
            addCriterion("approve_date is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDateEqualTo(Date value) {
            addCriterion("approve_date =", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotEqualTo(Date value) {
            addCriterion("approve_date <>", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThan(Date value) {
            addCriterion("approve_date >", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("approve_date >=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThan(Date value) {
            addCriterion("approve_date <", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThanOrEqualTo(Date value) {
            addCriterion("approve_date <=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateIn(List<Date> values) {
            addCriterion("approve_date in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotIn(List<Date> values) {
            addCriterion("approve_date not in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateBetween(Date value1, Date value2) {
            addCriterion("approve_date between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotBetween(Date value1, Date value2) {
            addCriterion("approve_date not between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIsNull() {
            addCriterion("user_money is null");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIsNotNull() {
            addCriterion("user_money is not null");
            return (Criteria) this;
        }

        public Criteria andUserMoneyEqualTo(Integer value) {
            addCriterion("user_money =", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotEqualTo(Integer value) {
            addCriterion("user_money <>", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyGreaterThan(Integer value) {
            addCriterion("user_money >", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_money >=", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyLessThan(Integer value) {
            addCriterion("user_money <", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("user_money <=", value, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyIn(List<Integer> values) {
            addCriterion("user_money in", values, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotIn(List<Integer> values) {
            addCriterion("user_money not in", values, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyBetween(Integer value1, Integer value2) {
            addCriterion("user_money between", value1, value2, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("user_money not between", value1, value2, "userMoney");
            return (Criteria) this;
        }

        public Criteria andUserClientCountIsNull() {
            addCriterion("user_client_count is null");
            return (Criteria) this;
        }

        public Criteria andUserClientCountIsNotNull() {
            addCriterion("user_client_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserClientCountEqualTo(Integer value) {
            addCriterion("user_client_count =", value, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountNotEqualTo(Integer value) {
            addCriterion("user_client_count <>", value, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountGreaterThan(Integer value) {
            addCriterion("user_client_count >", value, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_client_count >=", value, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountLessThan(Integer value) {
            addCriterion("user_client_count <", value, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_client_count <=", value, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountIn(List<Integer> values) {
            addCriterion("user_client_count in", values, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountNotIn(List<Integer> values) {
            addCriterion("user_client_count not in", values, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountBetween(Integer value1, Integer value2) {
            addCriterion("user_client_count between", value1, value2, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserClientCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_client_count not between", value1, value2, "userClientCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountIsNull() {
            addCriterion("user_sheng_proxy_count is null");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountIsNotNull() {
            addCriterion("user_sheng_proxy_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountEqualTo(Integer value) {
            addCriterion("user_sheng_proxy_count =", value, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountNotEqualTo(Integer value) {
            addCriterion("user_sheng_proxy_count <>", value, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountGreaterThan(Integer value) {
            addCriterion("user_sheng_proxy_count >", value, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_sheng_proxy_count >=", value, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountLessThan(Integer value) {
            addCriterion("user_sheng_proxy_count <", value, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_sheng_proxy_count <=", value, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountIn(List<Integer> values) {
            addCriterion("user_sheng_proxy_count in", values, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountNotIn(List<Integer> values) {
            addCriterion("user_sheng_proxy_count not in", values, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountBetween(Integer value1, Integer value2) {
            addCriterion("user_sheng_proxy_count between", value1, value2, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShengProxyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_sheng_proxy_count not between", value1, value2, "userShengProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountIsNull() {
            addCriterion("user_shi_proxy_count is null");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountIsNotNull() {
            addCriterion("user_shi_proxy_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountEqualTo(Integer value) {
            addCriterion("user_shi_proxy_count =", value, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountNotEqualTo(Integer value) {
            addCriterion("user_shi_proxy_count <>", value, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountGreaterThan(Integer value) {
            addCriterion("user_shi_proxy_count >", value, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_shi_proxy_count >=", value, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountLessThan(Integer value) {
            addCriterion("user_shi_proxy_count <", value, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_shi_proxy_count <=", value, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountIn(List<Integer> values) {
            addCriterion("user_shi_proxy_count in", values, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountNotIn(List<Integer> values) {
            addCriterion("user_shi_proxy_count not in", values, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountBetween(Integer value1, Integer value2) {
            addCriterion("user_shi_proxy_count between", value1, value2, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserShiProxyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_shi_proxy_count not between", value1, value2, "userShiProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountIsNull() {
            addCriterion("user_xian_proxy_count is null");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountIsNotNull() {
            addCriterion("user_xian_proxy_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountEqualTo(Integer value) {
            addCriterion("user_xian_proxy_count =", value, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountNotEqualTo(Integer value) {
            addCriterion("user_xian_proxy_count <>", value, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountGreaterThan(Integer value) {
            addCriterion("user_xian_proxy_count >", value, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_xian_proxy_count >=", value, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountLessThan(Integer value) {
            addCriterion("user_xian_proxy_count <", value, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_xian_proxy_count <=", value, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountIn(List<Integer> values) {
            addCriterion("user_xian_proxy_count in", values, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountNotIn(List<Integer> values) {
            addCriterion("user_xian_proxy_count not in", values, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountBetween(Integer value1, Integer value2) {
            addCriterion("user_xian_proxy_count between", value1, value2, "userXianProxyCount");
            return (Criteria) this;
        }

        public Criteria andUserXianProxyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_xian_proxy_count not between", value1, value2, "userXianProxyCount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}