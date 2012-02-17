package org.cfeclipse.cfmledit.editor.partitioner;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class CFMPartitionScanner extends RuleBasedPartitionScanner {

	//The partitions in a CFM document

	//Comments
	public final static String CF_COMMENT		= "__cf_comment";
	public final static String CF_SCRIPT_COMMENT_BLOCK = "__cf_script_comment_block";
	public final static String CF_SCRIPT_COMMENT = "__cf_script_comment";
	public final static String JAVADOC_COMMENT = "__cf_javadoc_comment";
	public final static String HTM_COMMENT 	= "__htm_comment";
	
	/*
	public final static String DOCTYPE	 	= "__doctype";
	public final static String CF_SCRIPT		= "__cf_script";
	public final static String CF_START_TAG = "__cf_start_tag";
	public final static String CF_START_TAG_BEGIN		= "__cf_start_tag_begin";
	public final static String CF_START_TAG_END		= "__cf_start_tag_end";
	public final static String CF_TAG_ATTRIBS		= "__cf_tag_attribs";
	public final static String CF_SET_STATEMENT = "__cf_set_statment";
	public final static String CF_RETURN_STATEMENT = "__cf_return_statement";
	public final static String CF_BOOLEAN_STATEMENT = "__cf_boolean_statement";
	public final static String CF_END_TAG		= "__cf_end_tag";
	public final static String HTM_START_TAG 		= "__htm_start_tag";
	public final static String HTM_END_TAG 		= "__htm_end_tag";
	public final static String HTM_START_TAG_BEGIN		= "__htm_start_tag_begin";
	public final static String HTM_START_TAG_END		= "__htm_start_tag_end";
	public final static String HTM_TAG_ATTRIBS		= "__htm_tag_attribs";
	public final static String CF_EXPRESSION		= "__cf_expression";
	public final static String J_SCRIPT		= "__jscript";
	public final static String CSS		= "__css";
	public final static String SQL		= "__sql";
	public final static String TAGLIB_TAG		= "__taglib_tag";
	public final static String UNK_TAG		= "__unk_tag";
	//form and table
	public final static String FORM_END_TAG		= "__form_end_tag";
	public final static String FORM_START_TAG		= "__form_start_tag";
	public final static String FORM_START_TAG_BEGIN		= "__form_start_tag_begin";
	public final static String FORM_TAG_ATTRIBS		= "__form_tag_attribs";
	public final static String FORM_START_TAG_END		= "__form_start_tag_end";
	public final static String TABLE_END_TAG		= "__table_end_tag";
	public final static String TABLE_START_TAG		= "__table_start_tag";
	public final static String TABLE_START_TAG_BEGIN		= "__table_start_tag_begin";
	public final static String TABLE_TAG_ATTRIBS		= "__table_tag_attribs";
	public final static String TABLE_START_TAG_END		= "__table_start_tag_end";
	*/
	
	public CFMPartitionScanner() {
		IToken cfComment = new Token(CF_COMMENT);
		IToken htmComment = new Token(HTM_COMMENT);
		
		IPredicateRule[] rules = new IPredicateRule[2];
		rules[0] = new MultiLineRule("<!---", "--->", cfComment);
		rules[1] = new MultiLineRule("<!--", "-->", htmComment);
		
		setPredicateRules(rules);
	
	}

	
}
