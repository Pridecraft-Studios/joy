package gay.pridecraft.joy.mixin.fix;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class JoyMixinCanceller implements MixinCanceller {

	@Override
	public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
		return mixinClassName.equals("io.github.akashiikun.mavapi.v1.mixin.MobBucketItemMixin");
	}
}