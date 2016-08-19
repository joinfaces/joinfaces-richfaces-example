package org.joinfaces.richfaces.example.beans;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.joinfaces.richfaces.example.model.Framework;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Named
@ConversationScoped
public class DragDropBean implements Serializable
{
	private static final long serialVersionUID = 1416925735640720492L;

	private static final FrameworkFamilyPredicate CF_PREDICATE = new FrameworkFamilyPredicate(Framework.Family.cf);
	private static final FrameworkFamilyPredicate DOT_NET_PREDICATE = new FrameworkFamilyPredicate(Framework.Family.dotNet);
	private static final FrameworkFamilyPredicate PHP_PREDICATE = new FrameworkFamilyPredicate(Framework.Family.php);

	private static final class FrameworkFamilyPredicate implements Predicate<Framework>
	{
		private Framework.Family family;

		public FrameworkFamilyPredicate(Framework.Family family) {
			super();
			this.family = family;
		}

		public boolean apply(Framework input) {
			return family.equals(input.getFamily());
		}
	}

	private List<Framework> source;
	private List<Framework> target;

	public DragDropBean() {
		initList();
	}

	public Collection<Framework> getSource() {
		return source;
	}

	public Collection<Framework> getTarget() {
		return target;
	}

	public List<Framework> getTargetPHP() {
		return Lists.newLinkedList(Collections2.filter(target, PHP_PREDICATE));
	}

	public List<Framework> getTargetDotNet() {
		return Lists.newLinkedList(Collections2.filter(target, DOT_NET_PREDICATE));
	}

	public List<Framework> getTargetCF() {
		return Lists.newLinkedList(Collections2.filter(target, CF_PREDICATE));
	}

	public void moveFramework(Framework framework) {
		source.remove(framework);
		target.add(framework);
	}

	public void reset() {
		initList();
	}

	private void initList() {
		source = Lists.newArrayList();
		target = Lists.newArrayList();

		source.add(new Framework("Flexible Ajax", Framework.Family.php));
		source.add(new Framework("ajaxCFC", Framework.Family.cf));
		source.add(new Framework("AJAXEngine", Framework.Family.dotNet));
		source.add(new Framework("AjaxAC", Framework.Family.php));
		source.add(new Framework("MonoRail", Framework.Family.dotNet));
		source.add(new Framework("wddxAjax", Framework.Family.cf));
		source.add(new Framework("AJAX AGENT", Framework.Family.php));
		source.add(new Framework("FastPage", Framework.Family.dotNet));
		source.add(new Framework("JSMX", Framework.Family.cf));
		source.add(new Framework("PAJAJ", Framework.Family.php));
		source.add(new Framework("Symfony", Framework.Family.php));
		source.add(new Framework("PowerWEB", Framework.Family.dotNet));
	}
}