/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2014 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.studio.api.v1.util.filter;

import org.craftercms.studio.api.v1.to.ContentItemTO;

public class ComponentFilter extends AbstractFilter {

    /**
     * filtering for components. compared with contentType and
     * contentType for pages is /cstudio-com/component/....
     *
     * @param item
     * @return true/false
     */

    public boolean filter(ContentItemTO item) {
        boolean isMatched = match(item.contentType);
        boolean isComponent = (!item.document && isMatched);
        item.component = isComponent;
        return isComponent;
    }
}
