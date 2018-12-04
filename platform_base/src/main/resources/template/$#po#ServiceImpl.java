/**
 * @author gaopj
 *
 */
package $#packageUrl#;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import $#mapperPackageUrl#;
import $#poPackageUrl#;
import $#voPackageUrl#;
import com.platform.base.service.impl.BaseServiceImpl;
import $#servicePackageUrl#;
@Service
public class $#po#ServiceImpl extends BaseServiceImpl<$#po#, $#vo#> implements $#po#Service {

	@Autowired
	private $#po#Mapper mapper;

}
