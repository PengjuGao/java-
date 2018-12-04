package ${controllerPackageName};

import ${poPackageName}.${poName};
import ${examplePackageName}.${exampleName};
<#if isBlobs>
import ${poPackageName}.${blobsName};
</#if>
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ${poName}Mapper {
        int countBy${exampleSuffix_upper}(${exampleName} ${exampleSuffix_lower});

        int deleteBy${exampleSuffix_upper}(${exampleName} ${exampleSuffix_lower});

<#if isBlobs>
        List<${blobsName}> selectBy${exampleSuffix_upper}WithBLOBs(${exampleName} ${exampleSuffix_lower});
</#if>
        List<${poName}> selectBy${exampleSuffix_upper}(${exampleName} ${exampleSuffix_lower});

<#if isBlobs>
        int updateBy${exampleSuffix_upper}Selective(@Param("record") ${blobsName} record, @Param("${exampleSuffix_lower}") ${exampleName} ${exampleSuffix_lower});

        int updateBy${exampleSuffix_upper}WithBLOBs(@Param("record") ${blobsName} record, @Param("${exampleSuffix_lower}") ${exampleName} ${exampleSuffix_lower});
        List<${blobsName}> selectBy${exampleSuffix_upper}WithBLOBsAndPage(${exampleName} ${exampleSuffix_lower}, RowBounds rowBound);
        int insert(${blobsName} record);
        int insertSelective(${blobsName} record);

        ${blobsName} selectByPrimaryKey(Integer hello);

        int updateByPrimaryKeySelective(${blobsName} record);

        int updateByPrimaryKeyWithBLOBs(${blobsName} record);
</#if>
        int updateBy${exampleSuffix_upper}(@Param("record") ${poName} record, @Param("${exampleSuffix_lower}") ${exampleName} ${exampleSuffix_lower});

        List<Test12> selectBy${exampleSuffix_upper}AndPage(${exampleName} ${exampleSuffix_lower}, RowBounds rowBound);

        int deleteByPrimaryKey(Integer hello);

        int updateByPrimaryKey(${poName} record);
}