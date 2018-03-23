package com.github.mrsuvez.json_jackson.runners;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@IncludeTags("slow")
@ExcludeTags("fast")
@SelectPackages("com.github.mrsuvez.json_jackson.domain")
@SuiteDisplayName("Test Suite Example")
@RunWith(JUnitPlatform.class)
public class JunitRunnerSlow {

}
