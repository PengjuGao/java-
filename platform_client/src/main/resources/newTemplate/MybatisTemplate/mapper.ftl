<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "mybatis-3-mapper.dtd" >
<mapper namespace="com.dao.Test12Mapper" >
    <resultMap id="BaseResultMap" type="com.pojo.Test12" >
        <id column="hello" property="hello" jdbcType="INTEGER" />
        <result column="xx" property="xx" jdbcType="VARCHAR" />
        <result column="er" property="er" jdbcType="TINYINT" />
        <result column="err" property="err" jdbcType="SMALLINT" />
        <result column="tt" property="tt" jdbcType="INTEGER" />
        <result column="yy" property="yy" jdbcType="INTEGER" />
        <result column="zz" property="zz" jdbcType="BIGINT" />
        <result column="wer" property="wer" jdbcType="BIT" />
        <result column="qws" property="qws" jdbcType="DOUBLE" />
        <result column="rfg" property="rfg" jdbcType="DOUBLE" />
        <result column="xxs" property="xxs" jdbcType="REAL" />
        <result column="tyu" property="tyu" jdbcType="DECIMAL" />
        <result column="tgb" property="tgb" jdbcType="DECIMAL" />
        <result column="thj" property="thj" jdbcType="CHAR" />
        <result column="zsd" property="zsd" jdbcType="DATE" />
        <result column="erf" property="erf" jdbcType="TIME" />
        <result column="ik" property="ik" jdbcType="DATE" />
        <result column="bnh" property="bnh" jdbcType="TIMESTAMP" />
        <result column="tsf" property="tsf" jdbcType="TIMESTAMP" />
        <result column="xcer" property="xcer" jdbcType="VARCHAR" />
        <result column="enume" property="enume" jdbcType="CHAR" />
        <result column="qyhb" property="qyhb" jdbcType="CHAR" />
        <result column="qerhld_hh" property="qerhldHh" jdbcType="OTHER" />
        <result column="fff" property="fff" jdbcType="OTHER" />
        <result column="ggg_hh_hh_bb" property="gggHhHhBb" jdbcType="OTHER" />
        <result column="yyut" property="yyut" jdbcType="OTHER" />
        <result column="ddddg_cc_writ" property="ddddgCcWrit" jdbcType="OTHER" />
        <result column="tfgbvcds" property="tfgbvcds" jdbcType="OTHER" />
        <result column="yuikmnbv_tt_uu_kk" property="yuikmnbvTtUuKk" jdbcType="OTHER" />
    </resultMap>
    <resultMap id="ResultMapWithBLOBs" type="com.pojo.Test12WithBLOBs" extends="BaseResultMap" >
        <result column="yhbdf" property="yhbdf" jdbcType="BINARY" />
        <result column="rfvc" property="rfvc" jdbcType="LONGVARBINARY" />
        <result column="qazxt" property="qazxt" jdbcType="LONGVARBINARY" />
        <result column="oikl" property="oikl" jdbcType="LONGVARBINARY" />
        <result column="bcsr" property="bcsr" jdbcType="LONGVARCHAR" />
        <result column="qlof" property="qlof" jdbcType="LONGVARCHAR" />
        <result column="ujdb" property="ujdb" jdbcType="LONGVARCHAR" />
        <result column="tgmklo" property="tgmklo" jdbcType="BINARY" />
        <result column="ujmv" property="ujmv" jdbcType="VARBINARY" />
        <result column="wttt" property="wttt" jdbcType="BINARY" />
    </resultMap>
    <sql id="Base_Column_List" >
        hello, xx, er, err, tt, yy, zz, wer, qws, rfg, xxs, tyu, tgb, thj, zsd, erf, ik,
        bnh, tsf, xcer, enume, qyhb, qerhld_hh, fff, ggg_hh_hh_bb, yyut, ddddg_cc_writ, tfgbvcds,
        yuikmnbv_tt_uu_kk
    </sql>
    <sql id="Blob_Column_List" >
        yhbdf, rfvc, qazxt, oikl, bcsr, qlof, ujdb, tgmklo, ujmv, wttt
    </sql>
    <sql id="Example_Where_Clause" >
        <where >
            <foreach collection="oredCriteria" item="criteria" separator="or" >
                <if test="criteria.valid" >
                    <trim prefix="(" suffix=")" prefixOverrides="and" >
                        <foreach collection="criteria.criteria" item="criterion" >
                            <choose >
                                <when test="criterion.noValue" >
                                    and ${criterion.condition}
                                </when>
                                <when test="criterion.singleValue" >
                                    and ${criterion.condition} #{criterion.value}
                                </when>
                                <when test="criterion.betweenValue" >
                                    and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                                </when>
                                <when test="criterion.listValue" >
                                    and ${criterion.condition}
                                    <foreach collection="criterion.value" item="listItem" open="(" close=")" separator="," >
                                        #{listItem}
                                    </foreach>
                                </when>
                            </choose>
                        </foreach>
                    </trim>
                </if>
            </foreach>
        </where>
    </sql>
    <sql id="Update_By_Example_Where_Clause" >
        <where >
            <foreach collection="example.oredCriteria" item="criteria" separator="or" >
                <if test="criteria.valid" >
                    <trim prefix="(" suffix=")" prefixOverrides="and" >
                        <foreach collection="criteria.criteria" item="criterion" >
                            <choose >
                                <when test="criterion.noValue" >
                                    and ${criterion.condition}
                                </when>
                                <when test="criterion.singleValue" >
                                    and ${criterion.condition} #{criterion.value}
                                </when>
                                <when test="criterion.betweenValue" >
                                    and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                                </when>
                                <when test="criterion.listValue" >
                                    and ${criterion.condition}
                                    <foreach collection="criterion.value" item="listItem" open="(" close=")" separator="," >
                                        #{listItem}
                                    </foreach>
                                </when>
                            </choose>
                        </foreach>
                    </trim>
                </if>
            </foreach>
        </where>
    </sql>
    <select id="selectByExampleWithBLOBs" resultMap="ResultMapWithBLOBs" parameterType="com.pojo.Test12Example" >
        select
        <if test="distinct" >
            distinct
        </if>
        <include refid="Base_Column_List" />
        ,
        <include refid="Blob_Column_List" />
        from test12
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
        <if test="orderByClause != null" >
            order by ${orderByClause}
        </if>
    </select>
    <select id="selectByExample" resultMap="BaseResultMap" parameterType="com.pojo.Test12Example" >
        select
        <if test="distinct" >
            distinct
        </if>
        <include refid="Base_Column_List" />
        from test12
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
        <if test="orderByClause != null" >
            order by ${orderByClause}
        </if>
    </select>
    <select id="selectByExampleWithBLOBsAndPage" resultMap="ResultMapWithBLOBs" parameterType="com.pojo.Test12Example" >
        select
        <if test="distinct" >
            distinct
        </if>
        <include refid="Base_Column_List" />
        ,
        <include refid="Blob_Column_List" />
        from test12
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
        <if test="orderByClause != null" >
            order by ${orderByClause}
        </if>
    </select>
    <select id="selectByExampleAndPage" resultMap="BaseResultMap" parameterType="com.pojo.Test12Example" >
        select
        <if test="distinct" >
            distinct
        </if>
        <include refid="Base_Column_List" />
        from test12
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
        <if test="orderByClause != null" >
            order by ${orderByClause}
        </if>
    </select>
    <delete id="deleteByExample" parameterType="com.pojo.Test12Example" >
        delete from test12
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
    </delete>
    <select id="countByExample" parameterType="com.pojo.Test12Example" resultType="java.lang.Integer" >
        select count(*) from test12
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
    </select>
    <update id="updateByExampleSelective" parameterType="map" >
        update test12
        <set >
            <if test="record.hello != null" >
                hello = #{record.hello,jdbcType=INTEGER},
            </if>
            <if test="record.xx != null" >
                xx = #{record.xx,jdbcType=VARCHAR},
            </if>
            <if test="record.er != null" >
                er = #{record.er,jdbcType=TINYINT},
            </if>
            <if test="record.err != null" >
                err = #{record.err,jdbcType=SMALLINT},
            </if>
            <if test="record.tt != null" >
                tt = #{record.tt,jdbcType=INTEGER},
            </if>
            <if test="record.yy != null" >
                yy = #{record.yy,jdbcType=INTEGER},
            </if>
            <if test="record.zz != null" >
                zz = #{record.zz,jdbcType=BIGINT},
            </if>
            <if test="record.wer != null" >
                wer = #{record.wer,jdbcType=BIT},
            </if>
            <if test="record.qws != null" >
                qws = #{record.qws,jdbcType=DOUBLE},
            </if>
            <if test="record.rfg != null" >
                rfg = #{record.rfg,jdbcType=DOUBLE},
            </if>
            <if test="record.xxs != null" >
                xxs = #{record.xxs,jdbcType=REAL},
            </if>
            <if test="record.tyu != null" >
                tyu = #{record.tyu,jdbcType=DECIMAL},
            </if>
            <if test="record.tgb != null" >
                tgb = #{record.tgb,jdbcType=DECIMAL},
            </if>
            <if test="record.thj != null" >
                thj = #{record.thj,jdbcType=CHAR},
            </if>
            <if test="record.zsd != null" >
                zsd = #{record.zsd,jdbcType=DATE},
            </if>
            <if test="record.erf != null" >
                erf = #{record.erf,jdbcType=TIME},
            </if>
            <if test="record.ik != null" >
                ik = #{record.ik,jdbcType=DATE},
            </if>
            <if test="record.bnh != null" >
                bnh = #{record.bnh,jdbcType=TIMESTAMP},
            </if>
            <if test="record.tsf != null" >
                tsf = #{record.tsf,jdbcType=TIMESTAMP},
            </if>
            <if test="record.xcer != null" >
                xcer = #{record.xcer,jdbcType=VARCHAR},
            </if>
            <if test="record.enume != null" >
                enume = #{record.enume,jdbcType=CHAR},
            </if>
            <if test="record.qyhb != null" >
                qyhb = #{record.qyhb,jdbcType=CHAR},
            </if>
            <if test="record.qerhldHh != null" >
                qerhld_hh = #{record.qerhldHh,jdbcType=OTHER},
            </if>
            <if test="record.fff != null" >
                fff = #{record.fff,jdbcType=OTHER},
            </if>
            <if test="record.gggHhHhBb != null" >
                ggg_hh_hh_bb = #{record.gggHhHhBb,jdbcType=OTHER},
            </if>
            <if test="record.yyut != null" >
                yyut = #{record.yyut,jdbcType=OTHER},
            </if>
            <if test="record.ddddgCcWrit != null" >
                ddddg_cc_writ = #{record.ddddgCcWrit,jdbcType=OTHER},
            </if>
            <if test="record.tfgbvcds != null" >
                tfgbvcds = #{record.tfgbvcds,jdbcType=OTHER},
            </if>
            <if test="record.yuikmnbvTtUuKk != null" >
                yuikmnbv_tt_uu_kk = #{record.yuikmnbvTtUuKk,jdbcType=OTHER},
            </if>
            <if test="record.yhbdf != null" >
                yhbdf = #{record.yhbdf,jdbcType=BINARY},
            </if>
            <if test="record.rfvc != null" >
                rfvc = #{record.rfvc,jdbcType=LONGVARBINARY},
            </if>
            <if test="record.qazxt != null" >
                qazxt = #{record.qazxt,jdbcType=LONGVARBINARY},
            </if>
            <if test="record.oikl != null" >
                oikl = #{record.oikl,jdbcType=LONGVARBINARY},
            </if>
            <if test="record.bcsr != null" >
                bcsr = #{record.bcsr,jdbcType=LONGVARCHAR},
            </if>
            <if test="record.qlof != null" >
                qlof = #{record.qlof,jdbcType=LONGVARCHAR},
            </if>
            <if test="record.ujdb != null" >
                ujdb = #{record.ujdb,jdbcType=LONGVARCHAR},
            </if>
            <if test="record.tgmklo != null" >
                tgmklo = #{record.tgmklo,jdbcType=BINARY},
            </if>
            <if test="record.ujmv != null" >
                ujmv = #{record.ujmv,jdbcType=VARBINARY},
            </if>
            <if test="record.wttt != null" >
                wttt = #{record.wttt,jdbcType=BINARY},
            </if>
        </set>
        <if test="_parameter != null" >
            <include refid="Update_By_Example_Where_Clause" />
        </if>
    </update>
    <update id="updateByExampleWithBLOBs" parameterType="map" >
        update test12
        set hello = #{record.hello,jdbcType=INTEGER},
        xx = #{record.xx,jdbcType=VARCHAR},
        er = #{record.er,jdbcType=TINYINT},
        err = #{record.err,jdbcType=SMALLINT},
        tt = #{record.tt,jdbcType=INTEGER},
        yy = #{record.yy,jdbcType=INTEGER},
        zz = #{record.zz,jdbcType=BIGINT},
        wer = #{record.wer,jdbcType=BIT},
        qws = #{record.qws,jdbcType=DOUBLE},
        rfg = #{record.rfg,jdbcType=DOUBLE},
        xxs = #{record.xxs,jdbcType=REAL},
        tyu = #{record.tyu,jdbcType=DECIMAL},
        tgb = #{record.tgb,jdbcType=DECIMAL},
        thj = #{record.thj,jdbcType=CHAR},
        zsd = #{record.zsd,jdbcType=DATE},
        erf = #{record.erf,jdbcType=TIME},
        ik = #{record.ik,jdbcType=DATE},
        bnh = #{record.bnh,jdbcType=TIMESTAMP},
        tsf = #{record.tsf,jdbcType=TIMESTAMP},
        xcer = #{record.xcer,jdbcType=VARCHAR},
        enume = #{record.enume,jdbcType=CHAR},
        qyhb = #{record.qyhb,jdbcType=CHAR},
        qerhld_hh = #{record.qerhldHh,jdbcType=OTHER},
        fff = #{record.fff,jdbcType=OTHER},
        ggg_hh_hh_bb = #{record.gggHhHhBb,jdbcType=OTHER},
        yyut = #{record.yyut,jdbcType=OTHER},
        ddddg_cc_writ = #{record.ddddgCcWrit,jdbcType=OTHER},
        tfgbvcds = #{record.tfgbvcds,jdbcType=OTHER},
        yuikmnbv_tt_uu_kk = #{record.yuikmnbvTtUuKk,jdbcType=OTHER},
        yhbdf = #{record.yhbdf,jdbcType=BINARY},
        rfvc = #{record.rfvc,jdbcType=LONGVARBINARY},
        qazxt = #{record.qazxt,jdbcType=LONGVARBINARY},
        oikl = #{record.oikl,jdbcType=LONGVARBINARY},
        bcsr = #{record.bcsr,jdbcType=LONGVARCHAR},
        qlof = #{record.qlof,jdbcType=LONGVARCHAR},
        ujdb = #{record.ujdb,jdbcType=LONGVARCHAR},
        tgmklo = #{record.tgmklo,jdbcType=BINARY},
        ujmv = #{record.ujmv,jdbcType=VARBINARY},
        wttt = #{record.wttt,jdbcType=BINARY}
        <if test="_parameter != null" >
            <include refid="Update_By_Example_Where_Clause" />
        </if>
    </update>
    <update id="updateByExample" parameterType="map" >
        update test12
        set hello = #{record.hello,jdbcType=INTEGER},
        xx = #{record.xx,jdbcType=VARCHAR},
        er = #{record.er,jdbcType=TINYINT},
        err = #{record.err,jdbcType=SMALLINT},
        tt = #{record.tt,jdbcType=INTEGER},
        yy = #{record.yy,jdbcType=INTEGER},
        zz = #{record.zz,jdbcType=BIGINT},
        wer = #{record.wer,jdbcType=BIT},
        qws = #{record.qws,jdbcType=DOUBLE},
        rfg = #{record.rfg,jdbcType=DOUBLE},
        xxs = #{record.xxs,jdbcType=REAL},
        tyu = #{record.tyu,jdbcType=DECIMAL},
        tgb = #{record.tgb,jdbcType=DECIMAL},
        thj = #{record.thj,jdbcType=CHAR},
        zsd = #{record.zsd,jdbcType=DATE},
        erf = #{record.erf,jdbcType=TIME},
        ik = #{record.ik,jdbcType=DATE},
        bnh = #{record.bnh,jdbcType=TIMESTAMP},
        tsf = #{record.tsf,jdbcType=TIMESTAMP},
        xcer = #{record.xcer,jdbcType=VARCHAR},
        enume = #{record.enume,jdbcType=CHAR},
        qyhb = #{record.qyhb,jdbcType=CHAR},
        qerhld_hh = #{record.qerhldHh,jdbcType=OTHER},
        fff = #{record.fff,jdbcType=OTHER},
        ggg_hh_hh_bb = #{record.gggHhHhBb,jdbcType=OTHER},
        yyut = #{record.yyut,jdbcType=OTHER},
        ddddg_cc_writ = #{record.ddddgCcWrit,jdbcType=OTHER},
        tfgbvcds = #{record.tfgbvcds,jdbcType=OTHER},
        yuikmnbv_tt_uu_kk = #{record.yuikmnbvTtUuKk,jdbcType=OTHER}
        <if test="_parameter != null" >
            <include refid="Update_By_Example_Where_Clause" />
        </if>
    </update>
    <select id="selectByPrimaryKey" resultMap="ResultMapWithBLOBs" parameterType="java.lang.Integer" >
        select
        <include refid="Base_Column_List" />
        ,
        <include refid="Blob_Column_List" />
        from test12
        where hello = #{hello,jdbcType=INTEGER}
    </select>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer" >
        delete from test12
        where hello = #{hello,jdbcType=INTEGER}
    </delete>
    <insert id="insert" parameterType="com.pojo.Test12WithBLOBs" >
        insert into test12 (hello, xx, er,
        err, tt, yy, zz,
        wer, qws, rfg, xxs,
        tyu, tgb, thj, zsd,
        erf, ik, bnh, tsf,
        xcer, enume, qyhb, qerhld_hh,
        fff, ggg_hh_hh_bb, yyut, ddddg_cc_writ,
        tfgbvcds, yuikmnbv_tt_uu_kk, yhbdf,
        rfvc, qazxt, oikl,
        bcsr, qlof, ujdb,
        tgmklo, ujmv, wttt)
        values (#{hello,jdbcType=INTEGER}, #{xx,jdbcType=VARCHAR}, #{er,jdbcType=TINYINT},
        #{err,jdbcType=SMALLINT}, #{tt,jdbcType=INTEGER}, #{yy,jdbcType=INTEGER}, #{zz,jdbcType=BIGINT},
        #{wer,jdbcType=BIT}, #{qws,jdbcType=DOUBLE}, #{rfg,jdbcType=DOUBLE}, #{xxs,jdbcType=REAL},
        #{tyu,jdbcType=DECIMAL}, #{tgb,jdbcType=DECIMAL}, #{thj,jdbcType=CHAR}, #{zsd,jdbcType=DATE},
        #{erf,jdbcType=TIME}, #{ik,jdbcType=DATE}, #{bnh,jdbcType=TIMESTAMP}, #{tsf,jdbcType=TIMESTAMP},
        #{xcer,jdbcType=VARCHAR}, #{enume,jdbcType=CHAR}, #{qyhb,jdbcType=CHAR}, #{qerhldHh,jdbcType=OTHER},
        #{fff,jdbcType=OTHER}, #{gggHhHhBb,jdbcType=OTHER}, #{yyut,jdbcType=OTHER}, #{ddddgCcWrit,jdbcType=OTHER},
        #{tfgbvcds,jdbcType=OTHER}, #{yuikmnbvTtUuKk,jdbcType=OTHER}, #{yhbdf,jdbcType=BINARY},
        #{rfvc,jdbcType=LONGVARBINARY}, #{qazxt,jdbcType=LONGVARBINARY}, #{oikl,jdbcType=LONGVARBINARY},
        #{bcsr,jdbcType=LONGVARCHAR}, #{qlof,jdbcType=LONGVARCHAR}, #{ujdb,jdbcType=LONGVARCHAR},
        #{tgmklo,jdbcType=BINARY}, #{ujmv,jdbcType=VARBINARY}, #{wttt,jdbcType=BINARY})
    </insert>
    <insert id="insertSelective" parameterType="com.pojo.Test12WithBLOBs" >
        insert into test12
        <trim prefix="(" suffix=")" suffixOverrides="," >
            hello,
            xx,
            er,
            err,
            tt,
            yy,
            zz,
            wer,
            qws,
            rfg,
            xxs,
            tyu,
            tgb,
            thj,
            zsd,
            erf,
            ik,
            bnh,
            tsf,
            xcer,
            enume,
            qyhb,
            qerhld_hh,
            fff,
            ggg_hh_hh_bb,
            yyut,
            ddddg_cc_writ,
            tfgbvcds,
            yuikmnbv_tt_uu_kk,
            yhbdf,
            rfvc,
            qazxt,
            oikl,
            bcsr,
            qlof,
            ujdb,
            tgmklo,
            ujmv,
            wttt,
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
            #{hello,jdbcType=INTEGER},
            #{xx,jdbcType=VARCHAR},
            #{er,jdbcType=TINYINT},
            #{err,jdbcType=SMALLINT},
            #{tt,jdbcType=INTEGER},
            #{yy,jdbcType=INTEGER},
            #{zz,jdbcType=BIGINT},
            #{wer,jdbcType=BIT},
            #{qws,jdbcType=DOUBLE},
            #{rfg,jdbcType=DOUBLE},
            #{xxs,jdbcType=REAL},
            #{tyu,jdbcType=DECIMAL},
            #{tgb,jdbcType=DECIMAL},
            #{thj,jdbcType=CHAR},
            #{zsd,jdbcType=DATE},
            #{erf,jdbcType=TIME},
            #{ik,jdbcType=DATE},
            #{bnh,jdbcType=TIMESTAMP},
            #{tsf,jdbcType=TIMESTAMP},
            #{xcer,jdbcType=VARCHAR},
            #{enume,jdbcType=CHAR},
            #{qyhb,jdbcType=CHAR},
            #{qerhldHh,jdbcType=OTHER},
            #{fff,jdbcType=OTHER},
            #{gggHhHhBb,jdbcType=OTHER},
            #{yyut,jdbcType=OTHER},
            #{ddddgCcWrit,jdbcType=OTHER},
            #{tfgbvcds,jdbcType=OTHER},
            #{yuikmnbvTtUuKk,jdbcType=OTHER},
            #{yhbdf,jdbcType=BINARY},
            #{rfvc,jdbcType=LONGVARBINARY},
            #{qazxt,jdbcType=LONGVARBINARY},
            #{oikl,jdbcType=LONGVARBINARY},
            #{bcsr,jdbcType=LONGVARCHAR},
            #{qlof,jdbcType=LONGVARCHAR},
            #{ujdb,jdbcType=LONGVARCHAR},
            #{tgmklo,jdbcType=BINARY},
            #{ujmv,jdbcType=VARBINARY},
            #{wttt,jdbcType=BINARY},
        </trim>
    </insert>
    <update id="updateByPrimaryKeySelective" parameterType="com.pojo.Test12WithBLOBs" >
        update test12
        <set >
            <if test="xx != null" >
                xx = #{xx,jdbcType=VARCHAR},
            </if>
            <if test="er != null" >
                er = #{er,jdbcType=TINYINT},
            </if>
            <if test="err != null" >
                err = #{err,jdbcType=SMALLINT},
            </if>
            <if test="tt != null" >
                tt = #{tt,jdbcType=INTEGER},
            </if>
            <if test="yy != null" >
                yy = #{yy,jdbcType=INTEGER},
            </if>
            <if test="zz != null" >
                zz = #{zz,jdbcType=BIGINT},
            </if>
            <if test="wer != null" >
                wer = #{wer,jdbcType=BIT},
            </if>
            <if test="qws != null" >
                qws = #{qws,jdbcType=DOUBLE},
            </if>
            <if test="rfg != null" >
                rfg = #{rfg,jdbcType=DOUBLE},
            </if>
            <if test="xxs != null" >
                xxs = #{xxs,jdbcType=REAL},
            </if>
            <if test="tyu != null" >
                tyu = #{tyu,jdbcType=DECIMAL},
            </if>
            <if test="tgb != null" >
                tgb = #{tgb,jdbcType=DECIMAL},
            </if>
            <if test="thj != null" >
                thj = #{thj,jdbcType=CHAR},
            </if>
            <if test="zsd != null" >
                zsd = #{zsd,jdbcType=DATE},
            </if>
            <if test="erf != null" >
                erf = #{erf,jdbcType=TIME},
            </if>
            <if test="ik != null" >
                ik = #{ik,jdbcType=DATE},
            </if>
            <if test="bnh != null" >
                bnh = #{bnh,jdbcType=TIMESTAMP},
            </if>
            <if test="tsf != null" >
                tsf = #{tsf,jdbcType=TIMESTAMP},
            </if>
            <if test="xcer != null" >
                xcer = #{xcer,jdbcType=VARCHAR},
            </if>
            <if test="enume != null" >
                enume = #{enume,jdbcType=CHAR},
            </if>
            <if test="qyhb != null" >
                qyhb = #{qyhb,jdbcType=CHAR},
            </if>
            <if test="qerhldHh != null" >
                qerhld_hh = #{qerhldHh,jdbcType=OTHER},
            </if>
            <if test="fff != null" >
                fff = #{fff,jdbcType=OTHER},
            </if>
            <if test="gggHhHhBb != null" >
                ggg_hh_hh_bb = #{gggHhHhBb,jdbcType=OTHER},
            </if>
            <if test="yyut != null" >
                yyut = #{yyut,jdbcType=OTHER},
            </if>
            <if test="ddddgCcWrit != null" >
                ddddg_cc_writ = #{ddddgCcWrit,jdbcType=OTHER},
            </if>
            <if test="tfgbvcds != null" >
                tfgbvcds = #{tfgbvcds,jdbcType=OTHER},
            </if>
            <if test="yuikmnbvTtUuKk != null" >
                yuikmnbv_tt_uu_kk = #{yuikmnbvTtUuKk,jdbcType=OTHER},
            </if>
            <if test="yhbdf != null" >
                yhbdf = #{yhbdf,jdbcType=BINARY},
            </if>
            <if test="rfvc != null" >
                rfvc = #{rfvc,jdbcType=LONGVARBINARY},
            </if>
            <if test="qazxt != null" >
                qazxt = #{qazxt,jdbcType=LONGVARBINARY},
            </if>
            <if test="oikl != null" >
                oikl = #{oikl,jdbcType=LONGVARBINARY},
            </if>
            <if test="bcsr != null" >
                bcsr = #{bcsr,jdbcType=LONGVARCHAR},
            </if>
            <if test="qlof != null" >
                qlof = #{qlof,jdbcType=LONGVARCHAR},
            </if>
            <if test="ujdb != null" >
                ujdb = #{ujdb,jdbcType=LONGVARCHAR},
            </if>
            <if test="tgmklo != null" >
                tgmklo = #{tgmklo,jdbcType=BINARY},
            </if>
            <if test="ujmv != null" >
                ujmv = #{ujmv,jdbcType=VARBINARY},
            </if>
            <if test="wttt != null" >
                wttt = #{wttt,jdbcType=BINARY},
            </if>
        </set>
        where hello = #{hello,jdbcType=INTEGER}
    </update>
    <update id="updateByPrimaryKeyWithBLOBs" parameterType="com.pojo.Test12WithBLOBs" >
        update test12
        set xx = #{xx,jdbcType=VARCHAR},
        er = #{er,jdbcType=TINYINT},
        err = #{err,jdbcType=SMALLINT},
        tt = #{tt,jdbcType=INTEGER},
        yy = #{yy,jdbcType=INTEGER},
        zz = #{zz,jdbcType=BIGINT},
        wer = #{wer,jdbcType=BIT},
        qws = #{qws,jdbcType=DOUBLE},
        rfg = #{rfg,jdbcType=DOUBLE},
        xxs = #{xxs,jdbcType=REAL},
        tyu = #{tyu,jdbcType=DECIMAL},
        tgb = #{tgb,jdbcType=DECIMAL},
        thj = #{thj,jdbcType=CHAR},
        zsd = #{zsd,jdbcType=DATE},
        erf = #{erf,jdbcType=TIME},
        ik = #{ik,jdbcType=DATE},
        bnh = #{bnh,jdbcType=TIMESTAMP},
        tsf = #{tsf,jdbcType=TIMESTAMP},
        xcer = #{xcer,jdbcType=VARCHAR},
        enume = #{enume,jdbcType=CHAR},
        qyhb = #{qyhb,jdbcType=CHAR},
        qerhld_hh = #{qerhldHh,jdbcType=OTHER},
        fff = #{fff,jdbcType=OTHER},
        ggg_hh_hh_bb = #{gggHhHhBb,jdbcType=OTHER},
        yyut = #{yyut,jdbcType=OTHER},
        ddddg_cc_writ = #{ddddgCcWrit,jdbcType=OTHER},
        tfgbvcds = #{tfgbvcds,jdbcType=OTHER},
        yuikmnbv_tt_uu_kk = #{yuikmnbvTtUuKk,jdbcType=OTHER},
        yhbdf = #{yhbdf,jdbcType=BINARY},
        rfvc = #{rfvc,jdbcType=LONGVARBINARY},
        qazxt = #{qazxt,jdbcType=LONGVARBINARY},
        oikl = #{oikl,jdbcType=LONGVARBINARY},
        bcsr = #{bcsr,jdbcType=LONGVARCHAR},
        qlof = #{qlof,jdbcType=LONGVARCHAR},
        ujdb = #{ujdb,jdbcType=LONGVARCHAR},
        tgmklo = #{tgmklo,jdbcType=BINARY},
        ujmv = #{ujmv,jdbcType=VARBINARY},
        wttt = #{wttt,jdbcType=BINARY}
        where hello = #{hello,jdbcType=INTEGER}
    </update>
    <update id="updateByPrimaryKey" parameterType="com.pojo.Test12" >
        update test12
        set xx = #{xx,jdbcType=VARCHAR},
        er = #{er,jdbcType=TINYINT},
        err = #{err,jdbcType=SMALLINT},
        tt = #{tt,jdbcType=INTEGER},
        yy = #{yy,jdbcType=INTEGER},
        zz = #{zz,jdbcType=BIGINT},
        wer = #{wer,jdbcType=BIT},
        qws = #{qws,jdbcType=DOUBLE},
        rfg = #{rfg,jdbcType=DOUBLE},
        xxs = #{xxs,jdbcType=REAL},
        tyu = #{tyu,jdbcType=DECIMAL},
        tgb = #{tgb,jdbcType=DECIMAL},
        thj = #{thj,jdbcType=CHAR},
        zsd = #{zsd,jdbcType=DATE},
        erf = #{erf,jdbcType=TIME},
        ik = #{ik,jdbcType=DATE},
        bnh = #{bnh,jdbcType=TIMESTAMP},
        tsf = #{tsf,jdbcType=TIMESTAMP},
        xcer = #{xcer,jdbcType=VARCHAR},
        enume = #{enume,jdbcType=CHAR},
        qyhb = #{qyhb,jdbcType=CHAR},
        qerhld_hh = #{qerhldHh,jdbcType=OTHER},
        fff = #{fff,jdbcType=OTHER},
        ggg_hh_hh_bb = #{gggHhHhBb,jdbcType=OTHER},
        yyut = #{yyut,jdbcType=OTHER},
        ddddg_cc_writ = #{ddddgCcWrit,jdbcType=OTHER},
        tfgbvcds = #{tfgbvcds,jdbcType=OTHER},
        yuikmnbv_tt_uu_kk = #{yuikmnbvTtUuKk,jdbcType=OTHER}
        where hello = #{hello,jdbcType=INTEGER}
    </update>
</mapper>