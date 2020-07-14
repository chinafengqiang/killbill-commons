/*
 * Copyright 2010-2014 Ning, Inc.
 * Copyright 2014-2020 Groupon, Inc
 * Copyright 2020-2020 Equinix, Inc
 * Copyright 2014-2020 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.xmlloader;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.NONE)
public abstract class ValidatingConfig<Context> {

    protected Context root;

    public abstract ValidationErrors validate(Context root, ValidationErrors errors);

    public void initialize(final Context root) {
        this.root = root;
    }

    public Context getRoot() {
        return root;
    }

    protected void validateCollection(final Context context,
                                      final ValidationErrors errors,
                                      final ValidatingConfig<Context>[] configs) {
        for (final ValidatingConfig<Context> config : configs) {
            config.validate(context, errors);
        }
    }
}
